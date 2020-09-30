package com.nalmoussa;

import java.util.HashMap;

class TwoSum extends com.nalmoussa.IntegerArrayBase {
    TwoSum(Integer[] inputArray) {
        super(inputArray);
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
