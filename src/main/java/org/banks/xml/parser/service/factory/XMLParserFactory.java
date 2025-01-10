package org.banks.xml.parser.service.factory;

import org.banks.xml.parser.service.parser.XMLParser;

public interface XMLParserFactory {
    XMLParser newParser(String pathToXML);
}