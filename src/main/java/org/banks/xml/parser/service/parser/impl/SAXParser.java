package org.banks.xml.parser.service.parser.impl;

import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.service.parser.XMLParser;

import java.util.ArrayList;
import java.util.List;

public class SAXParser implements XMLParser {
    private List<Bank> banks = new ArrayList<>();
    @Override
    public List<Bank> parse(String pathToXML) {
        return null;
    }
}
