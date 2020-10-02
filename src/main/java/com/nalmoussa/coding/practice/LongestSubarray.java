package com.nalmoussa.coding.practice;

class LongestSubarray {
    static int findLongestSubarray(int[] array, int[] factors) {
        int maxCounter = 0;
        int counter = 0;

        for (int factor : factors) {
            for (int j = 0; j <= array.length; j++) {
                if ((j < array.length) && (array[j] % factor == 0)) {
                    counter++;
                } else {
                    maxCounter = Math.max(maxCounter, counter);
                    counter = 0;
                }
            }
        }
        return maxCounter;
    }
}
