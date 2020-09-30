package com.nalmoussa;

import java.util.HashMap;

class UniqueBinaryTreesCountMap {
    private HashMap<Integer, Integer> map;
    UniqueBinaryTreesCountMap(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Illegal Argument!");
        }
        else {
            map = new HashMap<>();
            for (int key = 0; key < n; key++) {
                int value = getUniqueCountFor(key);
                map.put(key, value);
            }
        }
    }

    private int getUniqueCountFor(int n) {
        int count = (n > 0) ? 0 : 1;

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                count += get(i) * get(n - i -1);
            }
        }

        return count;
    }

    int get(int n) {
        if (n < map.size()) {
            return map.get(n);
        }
        else {
            throw new IllegalArgumentException("Illegal Argument! n can't be bigger than " + (map.size() - 1));
        }
    }
}
