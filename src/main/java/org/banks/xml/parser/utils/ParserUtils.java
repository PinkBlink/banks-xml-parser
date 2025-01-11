package org.banks.xml.parser.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Period;
import java.time.format.DateTimeParseException;

public class ParserUtils {
    private static Logger logger = LogManager.getLogger(ParserUtils.class);

    public static double parseDouble(String potentialDouble) {
        try {
            return Double.parseDouble(potentialDouble);
        } catch (NumberFormatException e) {
            logger.warn("Attempt to parse string \"" + potentialDouble + "\" to Double. Replace with 0");
            return 0;
        }
    }

    public static Period parsePeriod(String potentialPeriod) {
        try {
            return Period.parse(potentialPeriod);
        } catch (DateTimeParseException e) {
            logger.warn("Attempt to parse string \"" + potentialPeriod + "\" to Period. Replace with Period.ZERO");
            return Period.ZERO;
        }
    }
}
