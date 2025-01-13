package org.banks.xml.parser.service.factory.impl;

import org.banks.xml.parser.service.factory.XMLParserFactory;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.XMLParserSAX;

import java.awt.event.WindowStateListener;

public class SAXParserFactory implements XMLParserFactory {
    private static SAXParserFactory instance;

    private SAXParserFactory() {
    }

    public static SAXParserFactory getInstance() {
        if (instance == null) {
            instance = new SAXParserFactory();
        }
        return instance;
    }

    @Override
    public XMLParser newParser(String pathToXML) {
        return new XMLParserSAX(pathToXML);
    }
}