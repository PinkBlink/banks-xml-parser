package org.banks.xml.parser.service.parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.banks.xml.parser.exception.InvalidFileException;
import org.banks.xml.parser.exception.InvalidXMLException;
import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.model.DepositType;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.utils.IDUtils;
import org.banks.xml.parser.utils.ParserUtils;
import org.banks.xml.parser.utils.constants.TextConstants;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.banks.xml.parser.utils.constants.TagConstants.*;

public class XMLParserStAX implements XMLParser {
    private Logger logger = LogManager.getLogger(this);
    private XMLInputFactory xmlInputFactory;
    private String pathToXML;
    private Bank.BankBuilder bankBuilder;
    private final List<Bank> banks = new ArrayList<>();
    private Optional<String> content;
    private Integer id;

    public XMLParserStAX(String pathToXML) {
        this.pathToXML = pathToXML;
        xmlInputFactory = XMLInputFactory.newInstance();
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
                            bankBuilder = new Bank.BankBuilder();
                            id = null;
                        }
                    }

                    case XMLStreamReader.CHARACTERS -> {
                        content = Optional.ofNullable(xmlStreamReader.getText()).map(String::trim);
                    }

                    case XMLStreamReader.END_ELEMENT -> processEndElement(xmlStreamReader.getLocalName());
                }
            }
        } catch (IOException e) {
            logger.error("Problem with file " + pathToXML);
            throw new InvalidFileException(e.getMessage());
        } catch (XMLStreamException e) {
            logger.error("Problem with XML: " + pathToXML);
            throw new InvalidXMLException(e.getMessage());
        }
        return banks;
    }

    private void processEndElement(String endElement) {
        switch (endElement) {
            case BANK_NAME_TAG -> bankBuilder.setBankName(content.orElse(TextConstants.UNDEFINED));
            case COUNTRY_TAG -> bankBuilder.setCountry(content.orElse(TextConstants.UNDEFINED));
            case DEPOSITOR_NAME_TAG -> bankBuilder.setDepositorName(content.orElse(TextConstants.UNDEFINED));
            case ID_TAG -> {
                id = IDUtils.parseId(content.orElse(null));
                bankBuilder.setAccountId(id);
            }
            case DEPOSIT_TYPE_TAG -> {
                DepositType depositType = DepositType.valueOf(content.orElse(DepositType.UNDEFINED.name()));
                bankBuilder.setDepositType(depositType);
            }
            case AMOUNT_ON_DEPOSIT_TAG -> {
                double amount = ParserUtils.parseDouble(content.orElse(TextConstants.ZERO));
                bankBuilder.setDepositAmount(amount);
            }
            case PROFITABILITY_TAG -> {
                double profitability = ParserUtils.parseDouble(content.orElse(TextConstants.ZERO));
                bankBuilder.setProfitability(profitability);
            }
            case TIME_CONSTRAINS_TAG -> {
                Period timeConstrains = ParserUtils.parsePeriod(content.orElse(TextConstants.ZERO));
                bankBuilder.setTimeConstrains(timeConstrains);
            }
            case BANK_TAG -> {
                if (id == null) {
                    id = IDUtils.getNewId();
                }
                Bank bank = bankBuilder.build();
                logger.info("Object created byy StAX parser " + bank);
                banks.add(bank);
            }
        }
    }

    @Override
    public String toString() {
        return "StAX parser";
    }
}