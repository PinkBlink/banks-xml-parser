package org.banks.xml.parser.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validator {
    private static Logger logger = LogManager.getLogger(Validator.class);

    public static boolean isNumber(String numberStr) {
        try {
            Double.parseDouble(numberStr);
            return true;
        } catch (NumberFormatException e) {
            logger.error("Attempt to parse string \"" + numberStr + "\" to double");
            return false;
        }
    }

    public static boolean isValidId(String potentialId) {
        return potentialId != null && !potentialId.isEmpty() && Validator.isNumber(potentialId);
    }
}