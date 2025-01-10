package org.banks.xml.test;

import org.banks.xml.parser.model.Bank;

import java.util.List;

public class TestConstants {
    public static final String VALID_PATH = "src/test/resources/valid_test.xml";
    public static final String INVALID_PATH = "invalid/path/to/file.data";
    public static final String EMPTY_FILE = "src/test/resources/empty.xml";
    public static final List<Bank> EXPECTED_BANKS = new ExpectedBanksContainer().getBanks();
    public static final String SAX_STRING = "sax";
    public  static final String STAX_STRING = "stax";
    public static final String DOM_STRING = "dom";
}