package org.banks.xml.parser.service.builder;

import org.banks.xml.parser.exception.WrongInputException;
import org.banks.xml.parser.service.factory.XMLParserFactory;
import org.banks.xml.parser.service.factory.impl.DOMParserFactory;
import org.banks.xml.parser.service.factory.impl.SAXParserFactory;
import org.banks.xml.parser.service.factory.impl.STAXParserFactory;
import org.banks.xml.parser.service.parser.XMLParser;


public class XMLParserBuilder {
    private String pathToXML;
    private XMLParserFactory xmlParserFactory;

    public void setPathToXML(String pathToXML) {
        this.pathToXML = pathToXML;
    }

    public void setParserType(String parserType) {
        xmlParserFactory = switch (parserType.trim().toUpperCase()) {
            case "DOM" -> new DOMParserFactory();
            case "SAX" -> new SAXParserFactory();
            case "STAX" -> new STAXParserFactory();
            default -> throw new WrongInputException("Wrong parser type: " + parserType);
        };
    }

    public XMLParser build() {
        if (pathToXML == null || xmlParserFactory == null) {
            throw new IllegalStateException("Path to XML or parser type must be set");
        }
        return xmlParserFactory.createParser(pathToXML);
    }
}