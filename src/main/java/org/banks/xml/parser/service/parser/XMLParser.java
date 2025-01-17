package org.banks.xml.parser.service.parser;

import org.banks.xml.parser.exception.InvalidFileException;
import org.banks.xml.parser.exception.InvalidXMLException;
import org.banks.xml.parser.model.Bank;

import java.util.List;

public interface XMLParser {
    List<Bank> parse() throws InvalidXMLException, InvalidFileException;
}