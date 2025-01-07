package org.banks.xml.parser.service.factory;

import org.banks.xml.parser.model.Bank;

public interface BankBuilderFactory {
    Bank.BankBuilder createBankBuilder();
}
