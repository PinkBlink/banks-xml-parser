package org.banks.xml.parser;

import org.banks.xml.parser.exception.InvalidFileException;
import org.banks.xml.parser.exception.InvalidXMLException;
import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.service.builder.impl.XMLParserBuilderImpl;
import org.banks.xml.parser.service.parser.XMLParser;
import org.banks.xml.parser.service.parser.impl.XMLParserDOM;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class XMLParserDOMTests {
    private String validPath = new File("src/test/resources/test.xml").getAbsolutePath();
    private String invalidPath = "invalid/path/to/file.data";
    private List<Bank> expectedBanks = new ExpectedBanksContainer().getBanks();
    private XMLParser xmlParserDOM = new XMLParserBuilderImpl()
            .setParserType("dom")
            .setPathToXML(validPath)
            .build();

    @Test
    public void parserTypeTest() {
        Assert.assertTrue(xmlParserDOM instanceof XMLParserDOM);
    }

    @Test
    public void parserDOMTest() throws InvalidFileException, InvalidXMLException {
        List<Bank> actual = xmlParserDOM.parse();
        Assert.assertEquals(actual, expectedBanks);
    }
}
