package com.nalmoussa.coding.practice.problem004;

import java.util.Map;
import java.util.TreeMap;

class NumberOfAtoms {
    private final TreeMap<String, Integer> treeMap;

    NumberOfAtoms() {
        treeMap = new TreeMap<>();
    }

    NumberOfAtoms add(String atom, Integer count) {
        treeMap.put(atom, count);
        return this;
    }

    NumberOfAtoms add(NumberOfAtoms numberOfAtoms) {
        String atom;
        Integer count;
        for (Map.Entry<String, Integer> entry : numberOfAtoms.treeMap.entrySet()) {
            atom = entry.getKey();
            count = entry.getValue();
            if (treeMap.containsKey(atom)) {
                count += treeMap.get(atom);
            }
            treeMap.put(atom, count);
        }
        return this;
    }

    NumberOfAtoms multiplyBy(Integer multiplier) {
        String atom;
        int count;
        if (multiplier > 1) {
            for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
                atom = entry.getKey();
                count = multiplier * entry.getValue();
                treeMap.replace(atom, count);
            }
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int count;
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            stringBuilder.append(entry.getKey());
            count = entry.getValue();
            if (count > 1) {
                stringBuilder.append(count);
            }
        }

        return stringBuilder.toString();
    }
}
