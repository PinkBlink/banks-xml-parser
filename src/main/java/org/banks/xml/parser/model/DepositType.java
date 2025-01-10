package org.banks.xml.parser.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.banks.xml.parser.exception.WrongInputException;

public enum DepositType {
    DEMAND,
    TERM,
    CHECKING,
    SAVINGS,
    SAVER,
    METALLIC;
}