package org.banks.xml.parser.exception;

public class WrongStateException extends IllegalStateException{
    public WrongStateException() {
        super();
    }

    public WrongStateException(String s) {
        super(s);
    }

    public WrongStateException(String message, Throwable cause) {
        super(message, cause);
    }
}
