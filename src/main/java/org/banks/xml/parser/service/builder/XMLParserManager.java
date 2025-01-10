package org.banks.xml.parser.service.builder;

import org.banks.xml.parser.service.builder.impl.ParserType;
import org.banks.xml.parser.service.parser.XMLParser;

public interface XMLParserManager {
    XMLParser getParser(ParserType parserType, String pathToXML);

}