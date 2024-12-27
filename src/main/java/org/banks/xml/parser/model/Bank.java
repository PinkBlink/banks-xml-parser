package org.banks.xml.parser.model;

import java.time.Period;
import java.util.Objects;

public class Bank {
    private String bankName;
    private String country;
    private String depositorName;
    private int accountId;
    private DepositType depositType;
    private double depositAmount;
    private double profitability;
    private Period timeConstrains;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepositorName() {
        return depositorName;
    }

    public void setDepositorName(String depositorName) {
        this.depositorName = depositorName;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public DepositType getDepositType() {
        return depositType;
    }

    public void setDepositType(DepositType depositType) {
        this.depositType = depositType;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getProfitability() {
        return profitability;
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    public Period getTimeConstrains() {
        return timeConstrains;
    }

    public void setTimeConstrains(Period timeConstrains) {
        this.timeConstrains = timeConstrains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bank bank)) {
            return false;
        }
        return accountId == bank.accountId
                && Double.compare(depositAmount, bank.depositAmount) == 0
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
