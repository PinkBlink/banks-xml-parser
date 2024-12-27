package org.banks.xml.parser.model;

public enum DepositType {
    DEMAND,
    TERM,
    CHECKING,
    SAVINGS,
    SAVER,
    METALLIC;

    public static DepositType parse(String stringType) {
        for (DepositType depositType : DepositType.values()) {
            if (stringType.trim().equalsIgnoreCase(depositType.toString())) {
                return depositType;
            }
        }
        throw new IllegalArgumentException("Wrong Deposit Type: " + stringType);
    }
}