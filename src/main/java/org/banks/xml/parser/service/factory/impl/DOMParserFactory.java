package org.banks.xml.parser.service.factory.impl;

import org.banks.xml.parser.service.builder.impl.ParserType;
import org.banks.xml.parser.service.factory.XMLParserFactory;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.XMLParserDOM;

public class DOMParserFactory implements XMLParserFactory {
    private static DOMParserFactory instance;

    private DOMParserFactory() {

    }

    public static DOMParserFactory getInstance() {
        if (instance == null) {
            instance = new DOMParserFactory();
        }
        return instance;
    }

    public XMLParser newParser(String pathToXML) {
        return new XMLParserDOM(pathToXML);
    }
}