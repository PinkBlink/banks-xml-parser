package org.banks.xml.parser.model;

import java.time.Period;
import java.util.Objects;

public class Bank {
    private final String bankName;
    private final String country;
    private final String depositorName;
    private final Integer accountId;
    private final DepositType depositType;
    private final double depositAmount;
    private final double profitability;
    private final Period timeConstrains;

    private Bank(BankBuilder bankBuilder) {
        this.bankName = bankBuilder.bankName;
        this.country = bankBuilder.country;
        this.accountId = bankBuilder.accountId;
        this.depositType = bankBuilder.depositType;
        this.depositorName = bankBuilder.depositorName;
        this.depositAmount = bankBuilder.depositAmount;
        this.profitability = bankBuilder.profitability;
        this.timeConstrains = bankBuilder.timeConstrains;
    }

    public String getBankName() {
        return bankName;
    }


    public String getCountry() {
        return country;
    }

    public String getDepositorName() {
        return depositorName;
    }

    public int getAccountId() {
        return accountId;
    }

    public DepositType getDepositType() {
        return depositType;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public double getProfitability() {
        return profitability;
    }

    public Period getTimeConstrains() {
        return timeConstrains;
    }

    public static class BankBuilder {
        private String bankName;
        private String country;
        private String depositorName;
        private int accountId;
        private DepositType depositType;
        private double depositAmount;
        private double profitability;
        private Period timeConstrains;

        public BankBuilder setBankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public BankBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public BankBuilder setDepositorName(String depositorName) {
            this.depositorName = depositorName;
            return this;
        }

        public BankBuilder setAccountId(int accountId) {
            this.accountId = accountId;
            return this;
        }

        public BankBuilder setDepositType(DepositType depositType) {
            this.depositType = depositType;
            return this;
        }

        public BankBuilder setDepositAmount(double depositAmount) {
            this.depositAmount = depositAmount;
            return this;
        }

        public BankBuilder setProfitability(double profitability) {
            this.profitability = profitability;
            return this;
        }

        public BankBuilder setTimeConstrains(Period timeConstrains) {
            this.timeConstrains = timeConstrains;
            return this;
        }

        public Bank build() {
            return new Bank(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bank bank)) {
            return false;
        }
        return Double.compare(depositAmount, bank.depositAmount) == 0
                && Double.compare(profitability, bank.profitability) == 0
                && Objects.equals(bankName, bank.bankName)
                && Objects.equals(country, bank.country)
                && Objects.equals(depositorName, bank.depositorName)
                && depositType == bank.depositType
                && Objects.equals(timeConstrains, bank.timeConstrains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, country
                , depositorName, accountId
                , depositType, depositAmount
                , profitability, timeConstrains);
    }

    @Override
    public String toString() {
        return "\n Bank" +
                "bankName='" + bankName + '\'' +
                ", country='" + country + '\'' +
                ", depositorName='" + depositorName + '\'' +
                ", accountId=" + accountId +
                ", depositType=" + depositType +
                ", depositAmount=" + depositAmount +
                ", profitability=" + profitability +
                ", timeConstrains=" + timeConstrains +
                "\n-------------";
    }
}