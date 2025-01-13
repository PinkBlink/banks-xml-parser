package org.banks.xml.parser.service.manager.impl;

import org.banks.xml.parser.service.manager.XMLParserManager;
import org.banks.xml.parser.service.factory.XMLParserFactory;
import org.banks.xml.parser.service.factory.impl.DOMParserFactory;
import org.banks.xml.parser.service.factory.impl.SAXParserFactory;
import org.banks.xml.parser.service.factory.impl.STAXParserFactory;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.ParserType;

import java.util.Map;


public class XMLParserManagerImpl implements XMLParserManager {
    private Map<ParserType, XMLParserFactory> parsers = Map.of(
            ParserType.DOM, DOMParserFactory.getInstance()
            , ParserType.SAX, SAXParserFactory.getInstance()
            , ParserType.STAX, STAXParserFactory.getInstance());

    @Override
    public XMLParser getParser(ParserType parserType, String pathToXML) {
        return parsers.get(parserType).newParser(pathToXML);
    }
}