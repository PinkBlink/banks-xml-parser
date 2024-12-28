package org.banks.xml.parser.exception;

import org.xml.sax.SAXException;

public class InvalidXMLException extends SAXException {
    public InvalidXMLException() {
        super();
    }

    public InvalidXMLException(String message) {
        super(message);
    }

    public InvalidXMLException(String message, Exception e) {
        super(message, e);
    }
}
