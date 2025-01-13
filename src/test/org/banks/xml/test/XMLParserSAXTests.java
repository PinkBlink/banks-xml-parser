package org.banks.xml.test;

import org.banks.xml.parser.exception.InvalidFileException;
import org.banks.xml.parser.exception.InvalidXMLException;
import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.service.manager.XMLParserManager;
import org.banks.xml.parser.service.parser.impl.ParserType;
import org.banks.xml.parser.service.manager.impl.XMLParserManagerImpl;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.XMLParserSAX;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.banks.xml.test.TestConstants.*;


public class XMLParserSAXTests {
    private XMLParserManager xmlParserManager;
    private ParserType parserTypeSAX;

    @BeforeTest
    private void setUp() {
        xmlParserManager = new XMLParserManagerImpl();
        parserTypeSAX = ParserType.SAX;
    }

    @Test
    public void parserTypeTest() {
        //Given
        XMLParser xmlParserSAX;

        //When
        xmlParserSAX = xmlParserManager.getParser(parserTypeSAX, VALID_PATH);

        //Then
        Assert.assertTrue(xmlParserSAX instanceof XMLParserSAX);
    }

    @Test
    public void parserSAXPositiveTest() throws InvalidFileException, InvalidXMLException {
        //Given
        List<Bank> expectedBanks = ExpectedBanksContainer.getBanks();
        List<Bank> actualBanks;
        XMLParser xmlParserSAX;

        //When
        xmlParserSAX = xmlParserManager.getParser(parserTypeSAX, VALID_PATH);

        //Then
        actualBanks = xmlParserSAX.parse();
        Assert.assertEquals(actualBanks, expectedBanks);
    }

    @Test
    public void parserSAXNegativeTest1() {
        //Given
        XMLParser xmlParserSAX;

        //When
        xmlParserSAX = xmlParserManager.getParser(parserTypeSAX, INVALID_PATH);

        //Then
        Assert.assertThrows(InvalidFileException.class, xmlParserSAX::parse);
    }

    @Test
    public void parserSAXNegativeTest2(){
        //Given
        XMLParser xmlParserSAX;

        //When
        xmlParserSAX = xmlParserManager.getParser(parserTypeSAX, EMPTY_FILE_PATH);

        //Then
        Assert.assertThrows(InvalidXMLException.class, xmlParserSAX::parse);
    }
}