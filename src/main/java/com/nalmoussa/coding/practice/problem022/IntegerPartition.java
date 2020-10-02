package com.nalmoussa.coding.practice.problem022;

import java.util.Random;

class IntegerPartition {
    private final boolean[] combinationArray;
    private final int sum;
    private final static Random RAND = new Random();

    static int next() {
        return RAND.nextInt(100);
    }

    IntegerPartition(int sum) {
        if (sum < 1) {
            throw new IllegalArgumentException("Target sum must be positive integer");
        }
        this.sum = sum;
        this.combinationArray = new boolean[sum+1]; // all elements are false
        this.combinationArray[0] = true;
    }

    boolean hasCombination(int newElement) {
        if ((newElement > 0) && (newElement <= sum)) {
            if (combinationArray[sum - newElement]) {
                return true;
            }
            for (int currentSum = sum; currentSum > 0; currentSum--) {
                if (currentSum >= newElement) {
                    combinationArray[currentSum] = combinationArray[currentSum] || combinationArray[currentSum - newElement];
                }
            }
        }
        return false;
    }
}
