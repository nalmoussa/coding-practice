package com.nalmoussa.coding.practice;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTests {
    @Test
    public void verifyConstructorThrowsIllegalArgumentExceptionWhenArrayIsNull() {
        boolean hasException = false;
        try {
            new TwoSum(null);
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
    public void verifySolveWorksAsExpectedWhenAnswerHasNegativeNumber() {
        Integer[] inputArray = {3, 2, 1, 5, 8, 21, 0, -1};
        int target = 20;
        int[] expectedIndex = {5, 7};
        verifySolveWorksAsExpected(inputArray, target, expectedIndex);
    }

    @Test
    public void verifySolveReturnsNullWhenArrayHasOneElementOnly() {
        Integer[] inputArray = {3};
        int target = 0;
        int[] index = new TwoSum(inputArray).solveFast(target);
        Assert.assertTrue("Solve method should return null when array has one element only", (index == null));
    }

    @Test
    public void verifySolveReturnNullWhenThereIsNoAnswer() {
        Integer[] inputArray = {3, 2, 1, 5, 8};
        int target = 20;
        int[] index = new TwoSum(inputArray).solveFast(target);
        Assert.assertTrue("Solve method should return null when array has no solution", (index == null));
    }

    @Test
    public void verifySolveWorksAsExpectedWhenArrayHasTwoNumbersOnly() {
        Integer[] inputArray = {4, 3};
        int target = 7;
        int[] expectedIndex = {0, 1};
        verifySolveWorksAsExpected(inputArray, target, expectedIndex);
    }

    @Test
    public void verifySolveWorksAsExpectedWhenArrayHasManyAnswers() {
        Integer[] inputArray = {1, 1, 1, 1, 1};
        int target = 2;
        int[] expectedIndex = {0, 1};
        verifySolveWorksAsExpected(inputArray, target, expectedIndex);
    }

    @Test
    public void verifySolveWorksAsExpectedWhenTargetIsNegative() {
        Integer[] inputArray = {-13, 1, 1, 1, 1};
        int target = -12;
        int[] expectedIndex = {0, 1};
        verifySolveWorksAsExpected(inputArray, target, expectedIndex);
    }

    @Test
    public void verifySolveWorksAsExpectedWhenTargetIsZeroAndArrayIsPositive() {
        Integer[] inputArray = {-12, 12, 1, 1, 1};
        int target = 0;
        int[] expectedIndex = {0, 1};
        verifySolveWorksAsExpected(inputArray, target, expectedIndex);
    }

    @Test
    public void verifySolveWorksAsExpectedWhenTargetIsZeroAndArrayIsZero() {
        Integer[] inputArray = {0, 0, 0, 0};
        int target = 0;
        int[] expectedIndex = {0, 1};
        verifySolveWorksAsExpected(inputArray, target, expectedIndex);
    }

    private void verifySolveWorksAsExpected(Integer[] inputArray, int target, int[] expectedIndex) {
        int[] actualIndex = new TwoSum(inputArray).solveFast(target);
        int sum = inputArray[actualIndex[0]] + inputArray[actualIndex[1]];
        boolean correctIndices = (actualIndex[0] == expectedIndex[0]) && (actualIndex[1] == expectedIndex[1]);
        Assert.assertTrue("The sum of the returned subarray should match the target", (sum == target));
        Assert.assertTrue("Solve should return the correct indices", correctIndices);
    }
}
