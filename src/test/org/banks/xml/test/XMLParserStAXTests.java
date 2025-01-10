package org.banks.xml.test;

import org.banks.xml.parser.exception.InvalidFileException;
import org.banks.xml.parser.exception.InvalidXMLException;
import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.service.builder.impl.XMLParserBuilderImpl;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.XMLParserStAX;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.banks.xml.test.TestConstants.*;


public class XMLParserStAXTests {

    @Test
    public void parserTypeTest() {
        XMLParser xmlParserDOM = new XMLParserBuilderImpl()
                .setParserType(STAX_STRING)
                .setPathToXML(INVALID_PATH)
                .build();
        Assert.assertTrue(xmlParserDOM instanceof XMLParserStAX);
    }

    @Test
    public void parserStAXPositiveTest() throws InvalidFileException, InvalidXMLException {
        XMLParser xmlParserDOM = new XMLParserBuilderImpl()
                .setParserType(STAX_STRING)
                .setPathToXML(VALID_PATH)
                .build();
        List<Bank> actual = xmlParserDOM.parse();
        Assert.assertEquals(actual, EXPECTED_BANKS);
    }

    @Test(expectedExceptions = InvalidFileException.class)
    public void parserStAXNegativeTest1() throws InvalidFileException, InvalidXMLException {
        List<Bank> result = new XMLParserBuilderImpl()
                .setParserType(STAX_STRING)
                .setPathToXML(INVALID_PATH)
                .build()
                .parse();
    }

    @Test(expectedExceptions = InvalidXMLException.class)
    public void parserStAXNegativeTest2() throws InvalidFileException, InvalidXMLException {
        List<Bank> result = new XMLParserBuilderImpl()
                .setParserType(STAX_STRING)
                .setPathToXML(EMPTY_FILE)
                .build()
                .parse();
    }
}