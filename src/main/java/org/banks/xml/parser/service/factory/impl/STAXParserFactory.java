package org.banks.xml.parser.service.factory.impl;

import org.banks.xml.parser.service.factory.XMLParserFactory;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.XMLParserStAX;

public class STAXParserFactory implements XMLParserFactory {
    private static STAXParserFactory instance;

    private STAXParserFactory() {
    }

    public static STAXParserFactory getInstance() {
        if (instance == null) {
            instance = new STAXParserFactory();
        }
        return instance;
    }

    @Override
    public XMLParser newParser(String pathToXML) {
        return new XMLParserStAX(pathToXML);
    }
}