package org.banks.xml.parser.service.parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.banks.xml.parser.exception.InvalidFileException;
import org.banks.xml.parser.exception.InvalidXMLException;
import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.service.parser.impl.sax.handler.BankHandler;
import org.banks.xml.parser.service.parser.XMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParserSAX implements XMLParser {
    private Logger logger = LogManager.getLogger(this);
    private String pathToXML;
    private List<Bank> banks = new ArrayList<>();

    public XMLParserSAX(String pathToXML) {
        this.pathToXML = pathToXML;
    }

    @Override
    public List<Bank> parse() throws InvalidXMLException, InvalidFileException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            BankHandler bankHandler = new BankHandler();
            File banksXML = new File(pathToXML);
            saxParser.parse(banksXML, bankHandler);
            banks.addAll(bankHandler.getBanks());
        } catch (ParserConfigurationException | SAXException e) {
            logger.error("Problem with XML " + pathToXML);
            throw new InvalidXMLException(e.getMessage());
        } catch (IOException e) {
            logger.error("Problem with file " + pathToXML);
            throw new InvalidFileException(e.getMessage());
        }
        return banks;
    }

    @Override
    public String toString() {
        return "SAX parser";
    }
}