package org.banks.xml.parser.service.factory.impl;

import org.banks.xml.parser.service.factory.XMLParserFactory;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.XMLParserSAX;

public class SAXParserFactory implements XMLParserFactory {
    @Override
    public XMLParser createParser(String pathToXML) {
        return new XMLParserSAX(pathToXML);
    }
}