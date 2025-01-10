package org.banks.xml.parser.utils;

import java.time.Period;

public class ParserUtils {
    public static double parseDouble(String potentialDouble) {
        return (potentialDouble != null && Validator.isNumber(potentialDouble))
                ? Double.parseDouble(potentialDouble)
                : 0;
    }

    public static Period parsePeriod(String potentialPeriod) {
        return (potentialPeriod != null)
                ? Period.parse(potentialPeriod)
                : Period.ZERO;
    }
}
