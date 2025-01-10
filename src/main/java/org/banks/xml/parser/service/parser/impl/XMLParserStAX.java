package org.banks.xml.parser.service.parser.impl;

import org.banks.xml.parser.exception.InvalidFileException;
import org.banks.xml.parser.exception.InvalidXMLException;
import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.model.DepositType;
import org.banks.xml.parser.service.factory.BankBuilderFactory;
import org.banks.xml.parser.service.factory.impl.BankBuilderFactoryImpl;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.utils.IDUtils;
import org.banks.xml.parser.utils.ParserUtils;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static org.banks.xml.parser.utils.constants.TagConstants.*;

public class XMLParserStAX implements XMLParser {
    private XMLInputFactory xmlInputFactory;
    private BankBuilderFactory bankBuilderFactory;
    private Bank.BankBuilder bankBuilder;
    private List<Bank> banks = new ArrayList<>();
    private String pathToXML;
    private String content = null;
    private int id;

    public XMLParserStAX(String pathToXML) {
        this.pathToXML = pathToXML;
        xmlInputFactory = XMLInputFactory.newInstance();
        bankBuilderFactory = new BankBuilderFactoryImpl();
    }

    @Override
    public List<Bank> parse() throws InvalidFileException, InvalidXMLException {
        try (FileInputStream fileInputStream = new FileInputStream(pathToXML)) {
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(pathToXML, fileInputStream);
            while (xmlStreamReader.hasNext()) {
                int event = xmlStreamReader.next();
                switch (event) {

                    case XMLStreamReader.START_ELEMENT -> {
                        if (xmlStreamReader.getLocalName().equals(BANK_TAG)) {
                            bankBuilder = bankBuilderFactory.createBankBuilder();
                            id = 0;
                        }
                    }

                    case XMLStreamReader.CHARACTERS -> content = xmlStreamReader.getText().trim();

                    case XMLStreamReader.END_ELEMENT -> processEndElement(xmlStreamReader.getLocalName());
                }
            }
        } catch (IOException e) {
            throw new InvalidFileException(e.getMessage());
        } catch (XMLStreamException e) {
            throw new InvalidXMLException(e.getMessage());
        }
        return banks;
    }

    private void processEndElement(String endElement) {
        switch (endElement) {
            case BANK_NAME_TAG -> bankBuilder.setBankName(content);
            case COUNTRY_TAG -> bankBuilder.setCountry(content);
            case DEPOSITOR_NAME_TAG -> bankBuilder.setDepositorName(content);
            case ID_TAG -> {
                int id = IDUtils.parseId(content);
                bankBuilder.setAccountId(id);
            }
            case DEPOSIT_TYPE_TAG -> {
                DepositType depositType = DepositType.parseDepositType(content);
                bankBuilder.setDepositType(depositType);
            }
            case AMOUNT_ON_DEPOSIT_TAG -> {
                double amount = ParserUtils.parseDouble(content);
                bankBuilder.setDepositAmount(amount);
            }
            case PROFITABILITY_TAG -> {
                double profitability = ParserUtils.parseDouble(content);
                bankBuilder.setProfitability(profitability);
            }
            case TIME_CONSTRAINS_TAG -> {
                Period timeConstrains = ParserUtils.parsePeriod(content);
                bankBuilder.setTimeConstrains(timeConstrains);
            }
            case BANK_TAG -> {
                if (id == 0) {
                    id = IDUtils.getNewId();
                }
                banks.add(bankBuilder.build());
            }
        }
    }
}