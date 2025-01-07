package org.banks.xml.parser.service.factory.impl;

import org.banks.xml.parser.service.factory.XMLParserFactory;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.XMLParserStAX;

public class STAXParserFactory implements XMLParserFactory {
    @Override
    public XMLParser createParser(String pathToXML) {
        return new XMLParserStAX(pathToXML);
    }
}