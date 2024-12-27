package org.banks.xml.parser.service.handler;

import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.model.DepositType;
import org.banks.xml.parser.utils.IDUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static org.banks.xml.parser.utils.contants.TagConstants.*;

public class BankHandler extends DefaultHandler {
    private List<Bank> banks = new ArrayList<>();
    private Bank bank = null;
    private String content = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(BANK_TAG)) {
            bank = new Bank();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case BANK_TAG -> {
                if (bank.getAccountId() == 0) {
                    bank.setAccountId(IDUtils.getNewId());
                }
                banks.add(bank);
            }
            case BANK_NAME_TAG -> bank.setBankName(content);
            case COUNTRY_TAG -> bank.setCountry(content);
            case ID_TAG -> bank.setAccountId(IDUtils.parseId(content));
            case DEPOSIT_TYPE_TAG -> bank.setDepositType(DepositType.parse(content));
            case AMOUNT_ON_DEPOSIT_TAG -> bank.setDepositAmount(Integer.parseInt(content));
            case PROFITABILITY_TAG -> bank.setProfitability(Integer.parseInt(content));
            case TIME_CONSTRAINS_TAG -> bank.setTimeConstrains(Period.parse(content));
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        content = String.copyValueOf(ch, start, length).trim();
    }
}