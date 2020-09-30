package com.nalmoussa;

class SubArrayWithTargetSum extends IntegerArrayBase {
    SubArrayWithTargetSum(Integer[] inputArray) {
        super(inputArray);
        if (isNegative()) {
            throw new IllegalArgumentException("The array is negative!!!");
        }
    }

    int[] solve(int target) {
        if (target < 0) {
            throw new IllegalArgumentException("Target should not be negative");
        }

        int sum = -1;
        int first = 0;
        int last = 0;
        while ((sum != target) && ((last < inputArray.length) || (sum > target))) {
            sum += (sum < target) ? ((sum == -1) ? inputArray[last++]+1 : inputArray[last++]) : ((last - first == 1) ? -inputArray[first++]-1 : -inputArray[first++]);
        }

        int[] index = null;
        if (sum == target) {
            index = new int[2];
            index[0] = first;
            index[1] = last-1;
        }

        return index;
    }
}
