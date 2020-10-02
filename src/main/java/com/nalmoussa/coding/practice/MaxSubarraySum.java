package com.nalmoussa.coding.practice;

class MaxSubarraySum {
    static void findMax(int[] array) {
        int max = Integer.MIN_VALUE;
        int[] subarrayTotal = new int[array.length];
        int leftIndex = -1;
        int rightIndex = 0;

        for (int shift = 0; shift < array.length; shift++) {
            for (int index = 0 ; index < array.length - shift; index++) {
                subarrayTotal[index] += array[index + shift];
                System.out.print(" " + subarrayTotal[index]);
                if (subarrayTotal[index] > max) {
                    leftIndex = index;
                    rightIndex = index + shift;
                    max = subarrayTotal[index];
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(String.format("Left Index: %d\nRight Index: %d\nMax: %d", leftIndex, rightIndex, max));
    }

    static void findMaxFast(int[] array) {
        int max = Integer.MIN_VALUE;
        int leftIndex = -1;
        int rightIndex = 0;
        int newRowSum = 0;
        int currentSum = 0;

        for (int shift = 0; shift < array.length; shift++) {
            newRowSum += array[shift];
            for (int index = 0 ; index < array.length - shift; index++) {
                currentSum = (index == 0) ? newRowSum : (currentSum - array[index-1] + array[index+shift]);
                System.out.print(" " + currentSum);
                if (currentSum > max) {
                    leftIndex = index;
                    rightIndex = index + shift;
                    max = currentSum;
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(String.format("Left Index: %d\nRight Index: %d\nMax: %d", leftIndex, rightIndex, max));
    }
}