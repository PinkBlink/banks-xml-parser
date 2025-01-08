package org.banks.xml.parser;

import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.model.DepositType;
import org.banks.xml.parser.service.factory.BankBuilderFactory;
import org.banks.xml.parser.service.factory.impl.BankBuilderFactoryImpl;

import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpectedBanksContainer {
    private List<Bank> banks = new ArrayList<>();

    public ExpectedBanksContainer() {
        setUp();
    }

    public List<Bank> getBanks() {
        return banks;
    }

    private void setUp() {
        BankBuilderFactory bankBuilderFactory = new BankBuilderFactoryImpl();
        Bank bank1 = bankBuilderFactory.createBankBuilder()
                .setBankName("Bank of America")
                .setCountry("USA")
                .setDepositorName("John Doe")
                .setDepositType(DepositType.TERM)
                .setDepositAmount(10000.50)
                .setProfitability(5.5)
                .setTimeConstrains(Period.parse("P2Y"))
                .build();

        Bank bank2 = bankBuilderFactory.createBankBuilder()
                .setBankName("Santander")
                .setCountry("Poland")
                .setDepositorName("Mike Wazowski")
                .setAccountId(1231)
                .setDepositType(DepositType.CHECKING)
                .setDepositAmount(1200.58)
                .setProfitability(0)
                .setTimeConstrains(Period.parse("P0Y11M0D"))
                .build();

        Bank bank3 = bankBuilderFactory.createBankBuilder()
                .setBankName("Deutsche Bank")
                .setCountry("Germany")
                .setDepositorName("Hans Müller")
                .setAccountId(789654)
                .setDepositType(DepositType.SAVINGS)
                .setDepositAmount(25000.75)
                .setProfitability(3.2)
                .setTimeConstrains(Period.parse("P3Y6M"))
                .build();

        Bank bank4 = bankBuilderFactory.createBankBuilder()
                .setBankName("BNP Paribas")
                .setCountry("France")
                .setDepositorName("Amelie Dupont")
                .setAccountId(564738)
                .setDepositType(DepositType.METALLIC)
                .setDepositAmount(8500.00)
                .setProfitability(4.0)
                .setTimeConstrains(Period.parse("P1Y"))
                .build();

        Bank bank5 = bankBuilderFactory.createBankBuilder()
                .setBankName("HSBC")
                .setCountry("UK")
                .setDepositorName("James Smith")
                .setAccountId(453276)
                .setDepositType(DepositType.SAVINGS)
                .setDepositAmount(14000.33)
                .setProfitability(2.5)
                .setTimeConstrains(Period.parse("P2Y3M"))
                .build();

        Bank bank6 = bankBuilderFactory.createBankBuilder()
                .setBankName("ING Bank")
                .setCountry("Netherlands")
                .setDepositorName("Sophie van Dijk")
                .setAccountId(782342)
                .setDepositType(DepositType.TERM)
                .setDepositAmount(5600.20)
                .setProfitability(3.8)
                .setTimeConstrains(Period.parse("P5Y"))
                .build();

        Bank bank7 = bankBuilderFactory.createBankBuilder()
                .setBankName("Bank of China")
                .setCountry("China")
                .setDepositorName("Wei Zhang")
                .setAccountId(998231)
                .setDepositType(DepositType.CHECKING)
                .setDepositAmount(1200.00)
                .setProfitability(1.0)
                .setTimeConstrains(Period.parse("P1Y0M10D"))
                .build();
        banks.addAll(Arrays.asList(bank1, bank2, bank3, bank4, bank5, bank6, bank7));
    }
}