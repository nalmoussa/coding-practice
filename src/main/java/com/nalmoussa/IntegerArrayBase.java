package com.nalmoussa;

abstract class IntegerArrayBase {
    Integer[] inputArray;

    IntegerArrayBase(Integer[] inputArray) {
        if ((inputArray == null) || (inputArray.length == 0)) {
            throw new IllegalArgumentException("The array is null, empty!!!");
        }
        this.inputArray = inputArray;
    }

    void printArray() {
        if ((inputArray == null) || (inputArray.length == 0)) {
            System.out.println("The array is null or empty");
        }
        else {
            for (int n : inputArray) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    boolean isNegative() {
        boolean answer = false;
        if ((inputArray != null) && (inputArray.length != 0)) {
            for (int n : inputArray) {
                if (n < 0) {
                    answer = true;
                    break;
                }
            }
        }

        return answer;
    }
}
