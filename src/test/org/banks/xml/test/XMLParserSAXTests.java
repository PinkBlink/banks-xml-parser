package org.banks.xml.test;
import org.banks.xml.parser.exception.InvalidFileException;
import org.banks.xml.parser.exception.InvalidXMLException;
import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.service.builder.impl.XMLParserBuilderImpl;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.XMLParserSAX;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.banks.xml.test.TestConstants.*;


public class XMLParserSAXTests {
    @Test
    public void parserTypeTest() {
        XMLParser xmlParserSAX = new XMLParserBuilderImpl()
                .setParserType(SAX_STRING)
                .setPathToXML(INVALID_PATH)
                .build();
        Assert.assertTrue(xmlParserSAX instanceof XMLParserSAX);
    }

    @Test
    public void parserSAXPositiveTest() throws InvalidFileException, InvalidXMLException {
        XMLParser xmlParserSAX = new XMLParserBuilderImpl()
                .setParserType(SAX_STRING)
                .setPathToXML(VALID_PATH)
                .build();
        List<Bank> actual = xmlParserSAX.parse();
        Assert.assertEquals(actual, EXPECTED_BANKS);
    }

    @Test(expectedExceptions = InvalidFileException.class)
    public void parserSAXNegativeTest1() throws InvalidFileException, InvalidXMLException {
        List<Bank> result = new XMLParserBuilderImpl()
                .setParserType(SAX_STRING)
                .setPathToXML(INVALID_PATH)
                .build()
                .parse();
    }

    @Test(expectedExceptions = InvalidXMLException.class)
    public void parserSAXNegativeTest2() throws InvalidFileException, InvalidXMLException {
        List<Bank> result = new XMLParserBuilderImpl()
                .setParserType(SAX_STRING)
                .setPathToXML(EMPTY_FILE)
                .build()
                .parse();
    }
}