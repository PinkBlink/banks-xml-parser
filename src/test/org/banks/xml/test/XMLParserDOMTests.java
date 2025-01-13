package org.banks.xml.test;

import org.banks.xml.parser.exception.InvalidFileException;
import org.banks.xml.parser.exception.InvalidXMLException;
import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.service.builder.XMLParserManager;
import org.banks.xml.parser.service.parser.impl.ParserType;
import org.banks.xml.parser.service.builder.impl.XMLParserManagerImpl;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.XMLParserDOM;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.banks.xml.test.TestConstants.*;

public class XMLParserDOMTests {
    private XMLParserManager xmlParserManager;
    private ParserType parserTypeDOM;

    @BeforeTest
    private void setUp() {
        xmlParserManager = new XMLParserManagerImpl();
        parserTypeDOM = ParserType.DOM;
    }

    @Test
    public void parserTypeTest() {
        //Given
        XMLParser xmlParserDOM;

        //When
        xmlParserDOM = xmlParserManager.getParser(parserTypeDOM, VALID_PATH);

        //Then
        Assert.assertTrue(xmlParserDOM instanceof XMLParserDOM);
    }

    @Test
    public void parserDOMPositiveTest() throws InvalidFileException, InvalidXMLException {
        //Given
        List<Bank> expectedBanks = ExpectedBanksContainer.getBanks();
        List<Bank> actualBanks;
        XMLParser xmlParserDOM;

        //When
        xmlParserDOM = xmlParserManager.getParser(parserTypeDOM, VALID_PATH);
        actualBanks = xmlParserDOM.parse();

        //Then
        Assert.assertEquals(actualBanks, expectedBanks);
    }

    @Test
    public void parserDOMNegativeTest1() {
        //Given
        XMLParser xmlParserDOM;

        //When
        xmlParserDOM = xmlParserManager.getParser(parserTypeDOM, INVALID_PATH);

        //Then
        Assert.assertThrows(InvalidFileException.class, xmlParserDOM::parse);
    }

    @Test
    public void parserDOMNegativeTest2() {
        //Given
        XMLParser xmlParserDOM;

        //When
        xmlParserDOM = xmlParserManager.getParser(parserTypeDOM, EMPTY_FILE_PATH);

        //Then
        Assert.assertThrows(InvalidXMLException.class, xmlParserDOM::parse);
    }
}