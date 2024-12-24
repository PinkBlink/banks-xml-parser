package org.banks.xml.parser.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IDUtils {
    private static final Set<Integer> ID_SET = new HashSet<>();

    public static Set<Integer> getIdSet() {
        return ID_SET;
    }

    public static int getNewId() {
        return generateNewId();
    }

    private static int generateNewId() {
        Random randomizer = new Random();
        int potentialId = randomizer.nextInt(Integer.MAX_VALUE);
        while (!isUniqueId(potentialId)) {
            potentialId = randomizer.nextInt();
        }
        ID_SET.add(potentialId);
        return potentialId;
    }

    public static boolean isUniqueId(int id) {
        return !ID_SET.contains(id);
    }
}
