package org.banks.xml.parser;

import org.banks.xml.parser.model.Bank;

import java.util.ArrayList;
import java.util.List;

public class ExpectedBanksContainer {
    private List<Bank> banks = new ArrayList<>();

    public ExpectedBanksContainer(){
        setUp();
    }

    private void setUp(){
    }
    /*<bank>
        <bank_name></bank_name>
        <country>USA</country>
        <depositor_name>John Doe</depositor_name>
        <deposit_type>TERM</deposit_type>
        <amount_on_deposit>10000.50</amount_on_deposit>
        <profitability>5.5</profitability>
        <time_constrains>P2Y</time_constrains>
    </bank>
    <bank>
        <bank_name>Santander</bank_name>
        <country>Poland</country>
        <depositor_name>Mike Wazowski</depositor_name>
        <id>1231</id>
        <deposit_type>CHECKING</deposit_type>
        <amount_on_deposit>1200.58</amount_on_deposit>
        <profitability>0</profitability>
        <time_constrains>P0Y11M0D</time_constrains>
    </bank>
    <bank>
        <bank_name>Deutsche Bank</bank_name>
        <country>Germany</country>
        <depositor_name>Hans Müller</depositor_name>
        <id>789654</id>
        <deposit_type>SAVINGS</deposit_type>
        <amount_on_deposit>25000.75</amount_on_deposit>
        <profitability>3.2</profitability>
        <time_constrains>P3Y6M</time_constrains>
    </bank>
    <bank>
        <bank_name>BNP Paribas</bank_name>
        <country>France</country>
        <depositor_name>Amelie Dupont</depositor_name>
        <id>564738</id>
        <deposit_type>METALLIC</deposit_type>
        <amount_on_deposit>8500.00</amount_on_deposit>
        <profitability>4.0</profitability>
        <time_constrains>P1Y</time_constrains>
    </bank>
    <bank>
        <bank_name>HSBC</bank_name>
        <country>UK</country>
        <depositor_name>James Smith</depositor_name>
        <id>453276</id>
        <deposit_type>SAVINGS</deposit_type>
        <amount_on_deposit>14000.33</amount_on_deposit>
        <profitability>2.5</profitability>
        <time_constrains>P2Y3M</time_constrains>
    </bank>
    <bank>
        <bank_name>ING Bank</bank_name>
        <country>Netherlands</country>
        <depositor_name>Sophie van Dijk</depositor_name>
        <id>782342</id>
        <deposit_type>TERM</deposit_type>
        <amount_on_deposit>5600.20</amount_on_deposit>
        <profitability>3.8</profitability>
        <time_constrains>P5Y</time_constrains>
    </bank>
    <bank>
        <bank_name>Bank of China</bank_name>
        <country>China</country>
        <depositor_name>Wei Zhang</depositor_name>
        <id>998231</id>
        <deposit_type>CHECKING</deposit_type>
        <amount_on_deposit>1200.00</amount_on_deposit>
        <profitability>1.0</profitability>
        <time_constrains>P1Y0M10D</time_constrains>
    </bank>
    */
}
