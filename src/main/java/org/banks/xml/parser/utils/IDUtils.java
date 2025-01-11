package org.banks.xml.parser.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IDUtils {
    private static final Set<Integer> ID_SET = new HashSet<>();

    public static int getNewId() {
        return generateNewId();
    }

    public static void addId(int id) {
        ID_SET.add(id);
    }

    private static int generateNewId() {
        Random randomizer = new Random();
        int potentialId = randomizer.nextInt(Integer.MAX_VALUE);
        while (!isUniqueId(potentialId)) {
            potentialId = randomizer.nextInt(Integer.MAX_VALUE);
        }
        ID_SET.add(potentialId);
        return potentialId;
    }

    public static boolean isUniqueId(int id) {
        return !ID_SET.contains(id);
    }

    public static int parseId(String potentialId) {
        if (!Validator.isValidId(potentialId)) {
            return generateNewId();
        }
        int id = Integer.parseInt(potentialId);
        if (!IDUtils.isUniqueId(id)) {
            return generateNewId();
        }
        IDUtils.addId(id);
        return id;
    }


}
