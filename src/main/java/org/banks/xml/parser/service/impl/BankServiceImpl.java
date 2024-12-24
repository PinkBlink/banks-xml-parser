package org.banks.xml.parser.service.impl;

import org.banks.xml.parser.service.BankService;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BankServiceImpl implements BankService {
    private Set<Integer> idList = new HashSet<>();

    public int getNewId() {
        return generateNewId();
    }

    private int generateNewId() {
        Random randomizer = new Random();
        int potentialId = randomizer.nextInt(Integer.MAX_VALUE);
        while (idList.contains(potentialId)) {
            potentialId = randomizer.nextInt();
        }
        idList.add(potentialId);
        return potentialId;
    }

}
