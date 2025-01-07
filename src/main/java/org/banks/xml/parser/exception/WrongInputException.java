package org.banks.xml.parser.exception;

public class WrongInputException extends IllegalArgumentException{
    public WrongInputException() {
        super();
    }

    public WrongInputException(String s) {
        super(s);
    }

    public WrongInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
