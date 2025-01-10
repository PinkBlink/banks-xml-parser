package org.banks.xml.test;

import org.banks.xml.parser.exception.InvalidFileException;
import org.banks.xml.parser.exception.InvalidXMLException;
import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.service.builder.impl.XMLParserBuilderImpl;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.XMLParserDOM;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.banks.xml.test.TestConstants.*;

public class XMLParserDOMTests {
    @Test
    public void parserTypeTest() {
        XMLParser xmlParserDOM = new XMLParserBuilderImpl()
                .setParserType(DOM_STRING)
                .setPathToXML(INVALID_PATH)
                .build();
        Assert.assertTrue(xmlParserDOM instanceof XMLParserDOM);
    }

    @Test
    public void parserDOMPositiveTest() throws InvalidFileException, InvalidXMLException {
        XMLParser xmlParserDOM = new XMLParserBuilderImpl()
                .setParserType(DOM_STRING)
                .setPathToXML(VALID_PATH)
                .build();
        List<Bank> actual = xmlParserDOM.parse();
        Assert.assertEquals(actual, EXPECTED_BANKS);
    }

    @Test(expectedExceptions = InvalidFileException.class)
    public void parserDOMNegativeTest1() throws InvalidFileException, InvalidXMLException {
        List<Bank> result = new XMLParserBuilderImpl()
                .setParserType(DOM_STRING)
                .setPathToXML(INVALID_PATH)
                .build()
                .parse();
    }

    @Test(expectedExceptions = InvalidXMLException.class)
    public void parserDOMNegativeTest2() throws InvalidFileException, InvalidXMLException {
        List<Bank> result = new XMLParserBuilderImpl()
                .setParserType(DOM_STRING)
                .setPathToXML(EMPTY_FILE)
                .build()
                .parse();
    }
}