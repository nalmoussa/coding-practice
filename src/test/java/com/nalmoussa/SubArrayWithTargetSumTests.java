package com.nalmoussa;

import org.junit.Assert;
import org.junit.Test;

public class SubArrayWithTargetSumTests {
    @Test
    public void verifyConstructorThrowsIllegalArgumentExceptionWhenArrayIsNull() {
        boolean hasException = false;
        try {
            new SubArrayWithTargetSum(null);
        }
        catch (IllegalArgumentException ex) {
            hasException = true;
        }

        Assert.assertTrue("The constructor should throw IllegalArgumentException when the input array is null.", hasException);
    }

    @Test
    public void verifyConstructorThrowsIllegalArgumentExceptionWhenArrayIsEmpty() {
        boolean hasException = false;
        try {
            Integer[] inputArray = new Integer[0];
            new SubArrayWithTargetSum(inputArray);
        }
        catch (IllegalArgumentException ex) {
            hasException = true;
        }

        Assert.assertTrue("The constructor should throw IllegalArgumentException when the input array is empty.", hasException);
    }

    @Test
    public void verifyConstructorThrowsIllegalArgumentExceptionWhenArrayIsNegative() {
        boolean hasException = false;
        try {
            Integer[] inputArray = {3, -1, 2};
            new SubArrayWithTargetSum(inputArray);
        }
        catch (IllegalArgumentException ex) {
            hasException = true;
        }

        Assert.assertTrue("The constructor should throw IllegalArgumentException when the input array is negative.", hasException);
    }

    @Test
    public void verifySolveThrowsIllegalArgumentExceptionWhenTargetIsNegative() {
        boolean hasException = false;
        try {
            Integer[] inputArray = {3, 1, 2};
            int target = -1;
            new SubArrayWithTargetSum(inputArray).solve(target);
        }
        catch (IllegalArgumentException ex) {
            hasException = true;
        }

        Assert.assertTrue("The constructor should throw IllegalArgumentException when the input array is negative.", hasException);
    }
    @Test
    public void verifySolveWorksAsExpectedWhenTargetIsLastElementInArray() {
        Integer[] inputArray = {13, 1, 3, 6, 2};
        int target = 2;
        int[] index = new SubArrayWithTargetSum(inputArray).solve(target);
        int sum = sumSolution(inputArray, index);
        boolean correctIndices = (index[0] == 4) && (index[1] == 4);
        Assert.assertTrue("The sum of the returned subarray should match the target", (sum == target));
        Assert.assertTrue("Solve should return the correct indices", correctIndices);
    }

    @Test
    public void verifySolveWorksAsExpectedWhenArrayStartsWithAnswerSubarray() {
        Integer[] inputArray = {2, 1, 3, 6, 2};
        int target = 3;
        int[] index = new SubArrayWithTargetSum(inputArray).solve(target);
        int sum = sumSolution(inputArray, index);
        boolean correctIndices = (index[0] == 0) && (index[1] == 1);
        Assert.assertTrue("The sum of the returned subarray should match the target", (sum == target));
        Assert.assertTrue("Solve should return the correct indices", correctIndices);
    }

    @Test
    public void verifySolveReturnsNullWhenTargetIsZeroAndArrayIsPositive() {
        Integer[] inputArray = {1, 4};
        int target = 0;
        int[] index = new SubArrayWithTargetSum(inputArray).solve(target);
        Assert.assertTrue("Solve should return null", (index == null));
    }

    @Test
    public void verifySolveWorksAsExpectedWhenTargetIsZeroAndArrayHasZero() {
        Integer[] inputArray = {1, 0, 4};
        int target = 0;
        int[] index = new SubArrayWithTargetSum(inputArray).solve(target);
        int sum = sumSolution(inputArray, index);
        boolean correctIndices = (index[0] == 1) && (index[1] == 1);
        Assert.assertTrue("The sum of the returned subarray should match the target", (sum == target));
        Assert.assertTrue("Solve should return the correct indices", correctIndices);
    }

    private int sumSolution(Integer[] inputArray, int[] index) {
        int sum = 0;
        for (int i = index[0]; i < index[1]+1; i++) {
            sum += inputArray[i];
        }
        return sum;
    }
}
