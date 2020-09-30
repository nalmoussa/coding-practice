package com.nalmoussa;

import java.util.Map;
import java.util.TreeMap;

class NumberOfAtoms {
    private TreeMap<String, Integer> treeMap;

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
        for (Map.Entry entry : numberOfAtoms.treeMap.entrySet()) {
            atom = (String)entry.getKey();
            count = (Integer)entry.getValue();
            if (treeMap.containsKey(atom)) {
                count += treeMap.get(atom);
            }
            treeMap.put(atom, count);
        }
        return this;
    }

    NumberOfAtoms multiplyBy(Integer multiplier) {
        String atom;
        Integer count;
        if (multiplier > 1) {
            for (Map.Entry entry : treeMap.entrySet()) {
                atom = (String)entry.getKey();
                count = multiplier * (Integer)entry.getValue();
                treeMap.replace(atom, count);
            }
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int count;
        for (Map.Entry entry : treeMap.entrySet()) {
            stringBuilder.append((String)entry.getKey());
            count = (Integer)entry.getValue();
            if (count > 1) {
                stringBuilder.append(count);
            }
        }

        return stringBuilder.toString();
    }
}
