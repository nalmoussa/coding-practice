package com.nalmoussa.coding.practice.problem013;

import java.util.HashMap;

class TwoSum {
    private final Integer[] inputArray;
    TwoSum(Integer[] inputArray) {
        if (inputArray == null) {
            throw new IllegalArgumentException("The array can not be null!!!");
        }
        if (inputArray.length == 0) {
            throw new IllegalArgumentException("The array is empty!!!");
        }
        this.inputArray = inputArray;
    }

    int[] solveFast(int target) {
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        int[] index = null;
        for (int i = 0; i < inputArray.length; i++) {
            if (integerHashMap.containsKey(inputArray[i])) {
                index = new int[2];
                index[0] = integerHashMap.get(inputArray[i]);
                index[1] = i;
                break;
            }
            else {
                integerHashMap.put(target - inputArray[i], i);
            }
        }
        return index;
    }
}
