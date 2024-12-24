package org.banks.xml.parser.parsing.impl;

import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.model.DepositType;
import org.banks.xml.parser.utils.IDUtils;
import org.banks.xml.parser.utils.contants.PathConstants;
import org.w3c.dom.Node;
import org.banks.xml.parser.parsing.XMLParser;
import org.banks.xml.parser.utils.contants.TagConstants;
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

import static org.banks.xml.parser.utils.contants.TagConstants.*;

public class DOMParser implements XMLParser {
    @Override
    public List<Bank> parse(String pathToXML) {
        List<Bank> banks = new ArrayList<>();
        NodeList nodeList = getNodeListFromXML(TagConstants.BANK_TAG, pathToXML);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element bankElement = (Element) nodeList.item(i);
            banks.add(getBankFromElement(bankElement));
        }
        return banks;
    }

    private NodeList getNodeListFromXML(String tag, String path) {
        File file = new File(path);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            Document document = documentBuilderFactory.newDocumentBuilder().parse(file);
            return document.getElementsByTagName(tag);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    private Bank getBankFromElement(Element element) {
        String bankName = getContent(element, BANK_NAME_TAG);
        String country = getContent(element, COUNTRY_TAG);
        String depositorName = getContent(element, DEPOSITOR_NAME_TAG);

        String potentialId = getContent(element, ID_TAG);
        int id = IDUtils.parseId(potentialId);

        String potentialType = getContent(element, DEPOSIT_TYPE_TAG);
        DepositType depositType = DepositType.parse(potentialType);

        String potentialAmount = getContent(element, AMOUNT_ON_DEPOSIT_TAG);
        double amountOnDeposit = (potentialAmount != null) ? Double.parseDouble(potentialAmount) : 0;

        String potentialProfitability = getContent(element, PROFITABILITY_TAG);
        double profitability = (potentialProfitability != null) ? Double.parseDouble(potentialProfitability) : 0;

        String potentialPeriod = getContent(element, TIME_CONSTRAINS_TAG);
        Period period = (potentialPeriod != null) ? Period.parse(potentialPeriod) : Period.ZERO;

        return new Bank(bankName, country, depositorName, id, depositType, amountOnDeposit, profitability, period);
    }

    private String getContent(Element element, String tag) {
        Node content = element.getElementsByTagName(tag).item(0);
        if (content == null) {
            return null;
        } else {
            return content.getTextContent();
        }
    }

    public static void main(String[] args) {
        XMLParser dom = new DOMParser();
        List<Bank> bank = dom.parse(PathConstants.PATH_TO_XML);
        System.out.println(bank);
    }
}
