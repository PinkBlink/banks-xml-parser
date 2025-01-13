package org.banks.xml.test;

import org.banks.xml.parser.exception.InvalidFileException;
import org.banks.xml.parser.exception.InvalidXMLException;
import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.service.builder.XMLParserManager;
import org.banks.xml.parser.service.parser.impl.ParserType;
import org.banks.xml.parser.service.builder.impl.XMLParserManagerImpl;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.XMLParserStAX;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.banks.xml.test.TestConstants.*;


public class XMLParserStAXTests {
    private XMLParserManager xmlParserManager;
    private ParserType parserTypeSTAX;

    @BeforeTest
    private void setUp() {
        xmlParserManager = new XMLParserManagerImpl();
        parserTypeSTAX = ParserType.STAX;
    }

    @Test
    public void parserTypeTest() {
        //Given
        XMLParser xmlParserSTAX;

        //When
        xmlParserSTAX = xmlParserManager.getParser(parserTypeSTAX, VALID_PATH);

        //Then
        Assert.assertTrue(xmlParserSTAX instanceof XMLParserStAX);
    }

    @Test
    public void parserSAXPositiveTest() throws InvalidFileException, InvalidXMLException {
        //Given
        List<Bank> expectedBanks = ExpectedBanksContainer.getBanks();
        List<Bank> actualBanks;
        XMLParser xmlParserSTAX;

        //When
        xmlParserSTAX = xmlParserManager.getParser(parserTypeSTAX, VALID_PATH);

        //Then
        actualBanks = xmlParserSTAX.parse();
        Assert.assertEquals(actualBanks, expectedBanks);
    }

    @Test
    public void parserSAXNegativeTest1() {
        //Given
        XMLParser xmlParserSTAX;

        //When
        xmlParserSTAX = xmlParserManager.getParser(parserTypeSTAX, INVALID_PATH);

        //Then
        Assert.assertThrows(InvalidFileException.class, xmlParserSTAX::parse);
    }

    @Test
    public void parserSAXNegativeTest2(){
        //Given
        XMLParser xmlParserSTAX;

        //When
        xmlParserSTAX = xmlParserManager.getParser(parserTypeSTAX, EMPTY_FILE_PATH);

        //Then
        Assert.assertThrows(InvalidXMLException.class, xmlParserSTAX::parse);
    }
}