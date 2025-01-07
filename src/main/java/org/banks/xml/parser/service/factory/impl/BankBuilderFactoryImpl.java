package org.banks.xml.parser.service.factory.impl;

import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.service.factory.BankBuilderFactory;

public class BankBuilderFactoryImpl implements BankBuilderFactory {
    @Override
    public Bank.BankBuilder createBankBuilder() {
        return new Bank.BankBuilder();
    }
}
