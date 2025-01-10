package org.banks.xml.parser.service.parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.banks.xml.parser.exception.InvalidFileException;
import org.banks.xml.parser.exception.InvalidXMLException;
import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.model.DepositType;
import org.banks.xml.parser.utils.IDUtils;
import org.banks.xml.parser.utils.ParserUtils;
import org.w3c.dom.Node;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.utils.constants.TagConstants;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import static org.banks.xml.parser.utils.constants.TagConstants.*;

public class XMLParserDOM implements XMLParser {
    private Logger logger = LogManager.getLogger(this);
    private String pathToXML;
    private Bank.BankBuilder bankBuilder = new Bank.BankBuilder();

    public XMLParserDOM(String pathToXML) {
        this.pathToXML = pathToXML;
    }

    @Override
    public List<Bank> parse() throws InvalidFileException, InvalidXMLException {
        List<Bank> banks = new ArrayList<>();
        NodeList nodeList = getNodeListFromXML(TagConstants.BANK_TAG, pathToXML);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element bankElement = (Element) nodeList.item(i);
            Bank bank = getBankFromElement(bankElement);
            logger.info("Object created by DOM parser : " + bank);
            banks.add(bank);
        }
        return banks;
    }

    private NodeList getNodeListFromXML(String tag, String path) throws InvalidFileException, InvalidXMLException {
        File file = new File(path);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            Document document = documentBuilderFactory.newDocumentBuilder().parse(file);
            return document.getElementsByTagName(tag);

        } catch (IOException e) {
            logger.error("Problem with file: " + path);
            throw new InvalidFileException(e.getMessage());
        } catch (ParserConfigurationException | SAXException e) {
            logger.error("Problem with XML:" + path + " or incorrect tag: " + tag);
            throw new InvalidXMLException(e.getMessage());
        }
    }

    private Bank getBankFromElement(Element element) {
        String bankName = getContent(element, BANK_NAME_TAG);
        String country = getContent(element, COUNTRY_TAG);
        String depositorName = getContent(element, DEPOSITOR_NAME_TAG);

        String potentialId = getContent(element, ID_TAG);
        int id = IDUtils.parseId(potentialId);

        String potentialType = getContent(element, DEPOSIT_TYPE_TAG);
        DepositType depositType = DepositType.valueOf(potentialType);

        String potentialAmount = getContent(element, AMOUNT_ON_DEPOSIT_TAG);
        double amountOnDeposit = ParserUtils.parseDouble(potentialAmount);

        String potentialProfitability = getContent(element, PROFITABILITY_TAG);
        double profitability = ParserUtils.parseDouble(potentialProfitability);

        String potentialPeriod = getContent(element, TIME_CONSTRAINS_TAG);
        Period period = ParserUtils.parsePeriod(potentialPeriod);

        return bankBuilder
                .setBankName(bankName)
                .setCountry(country)
                .setDepositorName(depositorName)
                .setAccountId(id)
                .setDepositType(depositType)
                .setDepositAmount(amountOnDeposit)
                .setProfitability(profitability)
                .setTimeConstrains(period)
                .build();
    }

    private String getContent(Element element, String tag) {
        Node content = element.getElementsByTagName(tag).item(0);
        if (content == null) {
            return null;
        }
        return content.getTextContent();
    }

    @Override
    public String toString() {
        return "DOM parser";
    }
}