package org.banks.xml.parser.service.manager;

import org.banks.xml.parser.service.parser.impl.ParserType;
import org.banks.xml.parser.service.parser.XMLParser;

public interface XMLParserManager {
    XMLParser getParser(ParserType parserType, String pathToXML);

}