package parsing;

import org.banks.xml.parser.model.Bank;

import java.util.List;

public interface XMLParser {
    List<Bank> parse(String pathToXML);
}