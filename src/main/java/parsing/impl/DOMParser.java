package parsing.impl;

import org.banks.xml.parser.model.Bank;
import org.banks.xml.parser.model.DepositType;
import org.banks.xml.parser.utils.IDUtils;
import org.banks.xml.parser.utils.Validator;
import parsing.XMLParser;
import org.banks.xml.parser.utils.contants.TagConstants;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

public class DOMParser implements XMLParser {
    @Override
    public List<Bank> parse(String pathToXML) {
        List<Bank> banks = new ArrayList<>();
        NodeList nodeList = getNodeListFromXML(TagConstants.BANK_TAG, pathToXML);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element bankElement = (Element) nodeList.item(i);
            banks.add(getBankFromElement(bankElement));
        }
        return banks;
    }

    private NodeList getNodeListFromXML(String tag, String path) {
        File file = new File(path);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            Document document = documentBuilderFactory.newDocumentBuilder().parse(file);
            return document.getElementsByTagName(tag);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    private Bank getBankFromElement(Element element) {
        String bankName = element.getAttribute(TagConstants.BANK_NAME_TAG);
        String country = element.getAttribute(TagConstants.COUNTRY_TAG);
        String depositorName = element.getAttribute(TagConstants.DEPOSITOR_NAME_TAG);
        String potentialId = element.getAttribute(TagConstants.ID_TAG);
        int id;
        if (potentialId.isEmpty() || !Validator.isNumber(potentialId)) {
            id = IDUtils.getNewId();
        } else {
            id = Integer.parseInt(potentialId);
            IDUtils.getIdSet().add(id);
        }
        DepositType depositType = DepositType.parse(element.getAttribute(TagConstants.DEPOSIT_TYPE_TAG));
        double amountOnDeposit = Double.parseDouble(element.getAttribute(TagConstants.AMOUNT_ON_DEPOSIT_TAG));
        double profitability = Double.parseDouble(element.getAttribute(TagConstants.PROFITABILITY_TAG));
        Duration duration = Duration.parse(element.getAttribute(TagConstants.TIME_CONSTRAINS_TAG));

        return new Bank(bankName, country, depositorName, id, depositType, amountOnDeposit, profitability, duration);
    }

    public static void main(String[] args) {
    }
}
