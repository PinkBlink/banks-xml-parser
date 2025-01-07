package org.banks.xml.parser.service.parser.impl.handler;

import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.model.DepositType;
import org.banks.xml.parser.service.factory.BankBuilderFactory;
import org.banks.xml.parser.service.factory.impl.BankBuilderFactoryImpl;
import org.banks.xml.parser.utils.IDUtils;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static org.banks.xml.parser.utils.constants.TagConstants.*;

public class BankHandler extends DefaultHandler {
    private List<Bank> banks = new ArrayList<>();
    private BankBuilderFactory bankBuilderFactory = new BankBuilderFactoryImpl();
    private Bank.BankBuilder bankBuilder;
    private String content = null;
    private int id;

    public List<Bank> getBanks() {
        return banks;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals(BANK_TAG)) {
            id = 0;
            bankBuilder = bankBuilderFactory.createBankBuilder();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case BANK_NAME_TAG -> bankBuilder.setBankName(content);
            case COUNTRY_TAG -> bankBuilder.setCountry(content);
            case ID_TAG -> id = IDUtils.parseId(content);
            case DEPOSIT_TYPE_TAG -> bankBuilder.setDepositType(DepositType.parse(content));
            case AMOUNT_ON_DEPOSIT_TAG -> bankBuilder.setDepositAmount(Double.parseDouble(content));
            case PROFITABILITY_TAG -> bankBuilder.setProfitability(Double.parseDouble(content));
            case TIME_CONSTRAINS_TAG -> bankBuilder.setTimeConstrains(Period.parse(content));
            case BANK_TAG -> {
                if (id == 0) {
                    id = IDUtils.getNewId();
                }
                bankBuilder.setAccountId(id);
                banks.add(bankBuilder.build());
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        content = String.copyValueOf(ch, start, length).trim();
    }
}