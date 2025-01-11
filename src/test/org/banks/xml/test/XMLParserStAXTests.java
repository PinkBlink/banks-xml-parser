package org.banks.xml.test;

import org.banks.xml.parser.exception.InvalidFileException;
import org.banks.xml.parser.exception.InvalidXMLException;
import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.service.parser.impl.ParserType;
import org.banks.xml.parser.service.builder.impl.XMLParserManagerImpl;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.XMLParserStAX;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.banks.xml.test.TestConstants.*;


public class XMLParserStAXTests {

    @Test
    public void parserTypeTest() {
        XMLParser xmlParserStAX = new XMLParserManagerImpl()
                .getParser(ParserType.STAX,VALID_PATH);
        Assert.assertTrue(xmlParserStAX instanceof XMLParserStAX);
    }

    @Test
    public void parserStAXPositiveTest() throws InvalidFileException, InvalidXMLException {
        XMLParser xmlParserStAX = new XMLParserManagerImpl()
                .getParser(ParserType.STAX,VALID_PATH);
        List<Bank> actual = xmlParserStAX.parse();
        Assert.assertEquals(actual, EXPECTED_BANKS);
    }

    @Test(expectedExceptions = InvalidFileException.class)
    public void parserStAXNegativeTest1() throws InvalidFileException, InvalidXMLException {
        List<Bank> result = new XMLParserManagerImpl()
                .getParser(ParserType.STAX,INVALID_PATH)
                .parse();
    }

    @Test(expectedExceptions = InvalidXMLException.class)
    public void parserStAXNegativeTest2() throws InvalidFileException, InvalidXMLException {
        List<Bank> result = new XMLParserManagerImpl()
                .getParser(ParserType.STAX,EMPTY_FILE)
                .parse();
    }
}