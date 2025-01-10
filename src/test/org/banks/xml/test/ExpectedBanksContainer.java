package org.banks.xml.test;

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
        Bank bank8 = bankBuilderFactory.createBankBuilder()
                .setBankName("UniCredit")
                .setCountry("Italy")
                .setDepositorName("Giulia Rossi")
                .setAccountId(341234)
                .setDepositType(DepositType.SAVINGS)
                .setDepositAmount(7000.45)
                .setProfitability(2.9)
                .setTimeConstrains(Period.parse("P3Y"))
                .build();

        Bank bank9 = bankBuilderFactory.createBankBuilder()
                .setBankName("Raiffeisen Bank")
                .setCountry("Austria")
                .setDepositorName("Karl Steiner")
                .setAccountId(459283)
                .setDepositType(DepositType.METALLIC)
                .setDepositAmount(3400.15)
                .setProfitability(5.1)
                .setTimeConstrains(Period.parse("P4Y2M"))
                .build();

        Bank bank10 = bankBuilderFactory.createBankBuilder()
                .setBankName("Credit Suisse")
                .setCountry("Switzerland")
                .setDepositorName("Elena Fischer")
                .setAccountId(764839)
                .setDepositType(DepositType.TERM)
                .setDepositAmount(15000.90)
                .setProfitability(3.0)
                .setTimeConstrains(Period.parse("P2Y"))
                .build();

        Bank bank11 = bankBuilderFactory.createBankBuilder()
                .setBankName("Sberbank")
                .setCountry("Russia")
                .setDepositorName("Ivan Petrov")
                .setAccountId(543672)
                .setDepositType(DepositType.CHECKING)
                .setDepositAmount(2300.10)
                .setProfitability(0.8)
                .setTimeConstrains(Period.parse("P6M"))
                .build();

        Bank bank12 = bankBuilderFactory.createBankBuilder()
                .setBankName("Scotiabank")
                .setCountry("Canada")
                .setDepositorName("Emma Brown")
                .setAccountId(873621)
                .setDepositType(DepositType.SAVINGS)
                .setDepositAmount(19500.00)
                .setProfitability(2.7)
                .setTimeConstrains(Period.parse("P3Y1M"))
                .build();

        Bank bank13 = bankBuilderFactory.createBankBuilder()
                .setBankName("Commonwealth Bank")
                .setCountry("Australia")
                .setDepositorName("Oliver Green")
                .setAccountId(125637)
                .setDepositType(DepositType.TERM)
                .setDepositAmount(6800.77)
                .setProfitability(4.3)
                .setTimeConstrains(Period.parse("P4Y"))
                .build();

        Bank bank14 = bankBuilderFactory.createBankBuilder()
                .setBankName("NORDEA")
                .setCountry("Sweden")
                .setDepositorName("Sofia Lund")
                .setAccountId(674982)
                .setDepositType(DepositType.METALLIC)
                .setDepositAmount(4300.89)
                .setProfitability(3.9)
                .setTimeConstrains(Period.parse("P2Y6M"))
                .build();

        Bank bank15 = bankBuilderFactory.createBankBuilder()
                .setBankName("HSBC")
                .setCountry("UK")
                .setDepositorName("Sarah Connor")
                .setAccountId(345678)
                .setDepositType(DepositType.SAVINGS)
                .setDepositAmount(5000.00)
                .setProfitability(1.8)
                .setTimeConstrains(Period.parse("P5Y"))
                .build();

        Bank bank16 = bankBuilderFactory.createBankBuilder()
                .setBankName("Deutsche Bank")
                .setCountry("Germany")
                .setDepositorName("James Bond")
                .setAccountId(987654)
                .setDepositType(DepositType.CHECKING)
                .setDepositAmount(3500.75)
                .setProfitability(0.5)
                .setTimeConstrains(Period.parse("P1Y2M"))
                .build();

        Bank bank17 = bankBuilderFactory.createBankBuilder()
                .setBankName("Bank of China")
                .setCountry("China")
                .setDepositorName("Li Wei")
                .setAccountId(987123)
                .setDepositType(DepositType.TERM)
                .setDepositAmount(20000.00)
                .setProfitability(4.5)
                .setTimeConstrains(Period.parse("P10Y"))
                .build();

        Bank bank18 = bankBuilderFactory.createBankBuilder()
                .setBankName("Citibank")
                .setCountry("USA")
                .setDepositorName("Michael Scott")
                .setAccountId(564738)
                .setDepositType(DepositType.SAVINGS)
                .setDepositAmount(8000.30)
                .setProfitability(2.0)
                .setTimeConstrains(Period.parse("P3Y"))
                .build();

        Bank bank19 = bankBuilderFactory.createBankBuilder()
                .setBankName("JPMorgan Chase")
                .setCountry("USA")
                .setDepositorName("Alice Wonderland")
                .setAccountId(112233)
                .setDepositType(DepositType.METALLIC)
                .setDepositAmount(15000.00)
                .setProfitability(3.2)
                .setTimeConstrains(Period.parse("P7Y"))
                .build();

        Bank bank20 = bankBuilderFactory.createBankBuilder()
                .setBankName("Barclays")
                .setCountry("UK")
                .setDepositorName("Peter Parker")
                .setAccountId(556677)
                .setDepositType(DepositType.CHECKING)
                .setDepositAmount(1000.00)
                .setProfitability(0.0)
                .setTimeConstrains(Period.parse("P5M"))
                .build();

        banks.addAll(Arrays.asList(bank1, bank2, bank3, bank4, bank5, bank6, bank7
                , bank8, bank9, bank10, bank11, bank12, bank13, bank14, bank15, bank16, bank17, bank18, bank19, bank20));
    }
}