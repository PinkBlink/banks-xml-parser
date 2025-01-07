package org.banks.xml.parser.service.parser.impl;

import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.service.parser.XMLParser;

import java.util.List;

public class XMLParserStAX implements XMLParser {
    private String pathToXML;

    public XMLParserStAX(String pathToXML) {
        this.pathToXML = pathToXML;
    }

    @Override
    public List<Bank> parse() {
        return null;
    }
}
