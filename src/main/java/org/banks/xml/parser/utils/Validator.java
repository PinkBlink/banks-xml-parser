package org.banks.xml.parser.utils;


public class Validator {
    public static boolean isNumber(String numberStr) {
        numberStr = numberStr.trim();
        for (int i = 0; i < numberStr.length(); i++) {
            char digit = numberStr.charAt(i);
            if (!Character.isDigit(digit) && digit != '.') {
                return false;
            }
        }
        return true;
    }
}