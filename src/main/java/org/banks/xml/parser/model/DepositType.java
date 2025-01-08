package org.banks.xml.parser.model;

import org.banks.xml.parser.exception.WrongInputException;

public enum DepositType {
    DEMAND,
    TERM,
    CHECKING,
    SAVINGS,
    SAVER,
    METALLIC;

    public static DepositType parseDepositType(String stringType) {
        for (DepositType depositType : DepositType.values()) {
            if (stringType.trim().equalsIgnoreCase(depositType.toString())) {
                return depositType;
            }
        }
        throw new WrongInputException("Wrong Deposit Type: " + stringType);
    }
}