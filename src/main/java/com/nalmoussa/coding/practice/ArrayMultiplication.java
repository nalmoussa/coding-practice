package com.nalmoussa.coding.practice;

class ArrayMultiplication extends IntegerArrayBase {
    private final int zeroCount;
    private final Integer nonZeroProduct;

    ArrayMultiplication(Integer[] inputArray) {
        super(inputArray);
        zeroCount = calculateZeroCount();
        nonZeroProduct = calculateNonZeroProduct();
    }

    Integer[] solve() {
        Integer[] result;
        switch (zeroCount) {
            case 0:
                result = solveForNonZeroArray();
                break;
            case 1:
                result = solveForOneZeroArray();
                break;
            default:
                result = solveForTwoOrMoreZeroArray();
                break;
        }
        return result;
    }

    private int calculateZeroCount() {
        int count = 0;
        for (Integer current : inputArray) {
            count += (current == 0) ? 1 : 0;
        }
        return count;
    }

    private Integer calculateNonZeroProduct() {
        int product = 1;
        for (Integer current : inputArray) {
            product *= (current == 0) ? 1 : current;
        }

        return product;
    }

    private Integer[] solveForNonZeroArray() {
        Integer[] resultArray = new Integer[inputArray.length];

        for (int index = 0; index < inputArray.length; index++) {
            resultArray[index] = nonZeroProduct / inputArray[index];
        }

        return resultArray;
    }

    private Integer[] solveForOneZeroArray() {
        Integer[] resultArray = new Integer[inputArray.length];

        for (int index = 0; index < inputArray.length; index++) {
            resultArray[index] = (inputArray[index] == 0) ? nonZeroProduct : 0;
        }

        return resultArray;
    }

    private Integer[] solveForTwoOrMoreZeroArray() {
        Integer[] resultArray = new Integer[inputArray.length];

        for (int index = 0; index < inputArray.length; index++) {
            resultArray[index] = 0;
        }

        return resultArray;
    }
}
