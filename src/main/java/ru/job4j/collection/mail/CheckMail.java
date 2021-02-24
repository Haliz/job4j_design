package ru.job4j.collection.mail;

import java.util.*;

public class CheckMail {
    public static Map<String, Set<String>> merge(Map<String, Set<String>> input) {
        Map<String, Set<String>> outMap = new HashMap<>();
        for (Map.Entry<String, Set<String>> item : input.entrySet()) {
            String key = item.getKey();
            for (Map.Entry<String, Set<String>> newItem : outMap.entrySet()) {
                int sizeValue = newItem.getValue().size() + item.getValue().size();
                Set<String> set = new HashSet<>(item.getValue());
                set.addAll(newItem.getValue());
                if (sizeValue != set.size()) {
                    item.setValue(set);
                    key = newItem.getKey();
                }
            }
                outMap.put(key, item.getValue());
        }
        return outMap;
    }
}
