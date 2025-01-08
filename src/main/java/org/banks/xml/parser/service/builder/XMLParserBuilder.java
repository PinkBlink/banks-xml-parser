package org.banks.xml.parser.service.builder;

import org.banks.xml.parser.service.parser.XMLParser;

public interface XMLParserBuilder {
    XMLParserBuilder setPathToXML(String pathToXML);
    XMLParserBuilder setParserType(String type);
    XMLParser build();

}
