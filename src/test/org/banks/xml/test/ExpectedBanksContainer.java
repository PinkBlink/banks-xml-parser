package org.banks.xml.test;

import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.model.DepositType;

import java.time.Period;
import java.util.ArrayList;
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
        createBankAndAddToList("Bank of America", "USA", "John Doe"
                , 0, DepositType.TERM, 10000.50, 5.5, "P2Y");
        createBankAndAddToList("Santander", "Poland", "Mike Wazowski"
                , 1231, DepositType.CHECKING, 1200.58, 0.0, "P0Y11M0D");
        createBankAndAddToList("Deutsche Bank", "Germany", "Hans Müller"
                , 789654, DepositType.SAVINGS, 25000.75, 3.2, "P3Y6M");
        createBankAndAddToList("BNP Paribas", "France", "Amelie Dupont"
                , 564738, DepositType.METALLIC, 8500.00, 4.0, "P1Y");
        createBankAndAddToList("HSBC", "UK", "James Smith"
                , 453276, DepositType.DEMAND, 14000.33, 2.5, "P2Y3M");
        createBankAndAddToList("ING Bank", "Netherlands", "Sophie van Dijk"
                , 782342, DepositType.TERM, 5600.20, 3.8, "P5Y");
        createBankAndAddToList("Bank of China", "China", "Wei Zhang"
                , 998231, DepositType.CHECKING, 1200.00, 1.0, "P1Y0M10D");
        createBankAndAddToList("UniCredit", "Italy", "Giulia Rossi"
                , 341234, DepositType.SAVINGS, 7000.45, 2.9, "P3Y");
        createBankAndAddToList("Raiffeisen Bank", "Austria", "Karl Steiner"
                , 459283, DepositType.METALLIC, 3400.15, 5.1, "P4Y2M");
        createBankAndAddToList("Credit Suisse", "Switzerland", "Elena Fischer"
                , 764839, DepositType.TERM, 15000.90, 3.0, "P2Y");
        createBankAndAddToList("Sberbank", "Russia", "Ivan Petrov"
                , 543672, DepositType.CHECKING, 2300.10, 0.8, "P6M");
        createBankAndAddToList("Scotiabank", "Canada", "Emma Brown"
                , 873621, DepositType.SAVINGS, 19500.00, 2.7, "P3Y1M");
        createBankAndAddToList("Commonwealth Bank", "Australia", "Oliver Green"
                , 125637, DepositType.TERM, 6800.77, 4.3, "P4Y");
        createBankAndAddToList("NORDEA", "Sweden", "Sofia Lund"
                , 674982, DepositType.METALLIC, 4300.89, 3.9, "P2Y6M");
        createBankAndAddToList("HSBC", "UK", "Sarah Connor"
                , 345678, DepositType.SAVINGS, 5000.00, 1.8, "P5Y");
        createBankAndAddToList("Deutsche Bank", "Germany", "James Bond"
                , 987654, DepositType.CHECKING, 3500.75, 0.5, "P1Y2M");
        createBankAndAddToList("Bank of China", "China", "Li Wei"
                , 987123, DepositType.TERM, 20000.00, 4.5, "P10Y");
        createBankAndAddToList("Citibank", "USA", "Michael Scott"
                , 564738, DepositType.SAVINGS, 8000.30, 2.0, "P3Y");
        createBankAndAddToList("JPMorgan Chase", "USA", "Alice Wonderland"
                , 112233, DepositType.METALLIC, 15000.00, 3.2, "P7Y");
        createBankAndAddToList("Barclays", "UK", "Peter Parker"
                , 556677, DepositType.CHECKING, 1000.00, 0.0, "P0Y5M");

    }

    private void createBankAndAddToList(String name, String country
            , String depositorName, int id
            , DepositType depositType, double depositAmount
            , double profitability, String period) {

        Bank.BankBuilder bankBuilder = new Bank.BankBuilder();
        Bank bank = bankBuilder.setBankName(name)
                .setCountry(country)
                .setDepositorName(depositorName)
                .setAccountId(id)
                .setDepositType(depositType)
                .setDepositAmount(depositAmount)
                .setProfitability(profitability)
                .setTimeConstrains(Period.parse(period))
                .build();
        banks.add(bank);
    }
}