package org.banks.xml.test;
import org.banks.xml.parser.exception.InvalidFileException;
import org.banks.xml.parser.exception.InvalidXMLException;
import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.service.builder.impl.ParserType;
import org.banks.xml.parser.service.builder.impl.XMLParserManagerImpl;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.XMLParserSAX;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.banks.xml.test.TestConstants.*;


public class XMLParserSAXTests {
    @Test
    public void parserTypeTest() {
        XMLParser xmlParserSAX = new XMLParserManagerImpl()
                .getParser(ParserType.SAX,INVALID_PATH);
        Assert.assertTrue(xmlParserSAX instanceof XMLParserSAX);
    }

    @Test
    public void parserSAXPositiveTest() throws InvalidFileException, InvalidXMLException {
        XMLParser xmlParserSAX = new XMLParserManagerImpl()
                .getParser(ParserType.SAX,VALID_PATH);
        List<Bank> actual = xmlParserSAX.parse();
        Assert.assertEquals(actual, EXPECTED_BANKS);
    }

    @Test(expectedExceptions = InvalidFileException.class)
    public void parserSAXNegativeTest1() throws InvalidFileException, InvalidXMLException {
        List<Bank> result = new XMLParserManagerImpl()
                .getParser(ParserType.SAX,INVALID_PATH)
                .parse();
    }

    @Test(expectedExceptions = InvalidXMLException.class)
    public void parserSAXNegativeTest2() throws InvalidFileException, InvalidXMLException {
        List<Bank> result = new XMLParserManagerImpl()
                .getParser(ParserType.SAX,EMPTY_FILE)
                .parse();
    }
}