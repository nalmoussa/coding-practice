package com.nalmoussa.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortUtilityTests {
    private static final Integer[] INPUT   = {5,3,6,7,2};
    private static final Integer[] EXPECTED_ASCENDING = {2,3,5,6,7};
    private static final Integer[] EXPECTED_DESCENDING = {7,6,5,3,2};

    @Test
    public void verifyBubbleSortWorks() {
        verifySortAlgorithmWorksAsExpected(SortAlgorithm.BUBBLE);
    }

    @Test
    public void verifyCocktailShakerSortWorks() {
        verifySortAlgorithmWorksAsExpected(SortAlgorithm.COCKTAIL_SHAKER);
    }

    @Test
    public void verifyCycleSortWorks() {
        verifySortAlgorithmWorksAsExpected(SortAlgorithm.CYCLE);
    }

    @Test
    public void verifyHeapSortWorks() {
        verifySortAlgorithmWorksAsExpected(SortAlgorithm.HEAP);
    }

    @Test
    public void verifyInsertionSortWorks() {
        verifySortAlgorithmWorksAsExpected(SortAlgorithm.INSERTION);
    }

    @Test
    public void verifyIntroSortWorks() {
        verifySortAlgorithmWorksAsExpected(SortAlgorithm.INTRO);
    }

    @Test
    public void verifyMergeSortWorks() {
        verifySortAlgorithmWorksAsExpected(SortAlgorithm.MERGE);
    }

    @Test
    public void verifyMergeInsertionSortWorks() {
        verifySortAlgorithmWorksAsExpected(SortAlgorithm.MERGE_INSERTION);
    }

    @Test
    public void verifyOddEvenSortWorks() {
        verifySortAlgorithmWorksAsExpected(SortAlgorithm.ODD_EVEN);
    }

    @Test
    public void verifyQuickSortWorks() {
        verifySortAlgorithmWorksAsExpected(SortAlgorithm.QUICK);
    }

    @Test
    public void verifySelectionSortWorks() {
        verifySortAlgorithmWorksAsExpected(SortAlgorithm.SELECTION);
    }

    @Test
    public void verifyShellSortWorks() {
        verifySortAlgorithmWorksAsExpected(SortAlgorithm.SHELL);
    }

    @Test
    public void verifySmoothSortWorks() {
        verifySortAlgorithmWorksAsExpected(SortAlgorithm.SMOOTH);
    }

    @Test
    public void verifyTimSortWorks() {
        verifySortAlgorithmWorksAsExpected(SortAlgorithm.TIM);
    }

    private void verifySortAlgorithmWorksAsExpected(SortAlgorithm sortAlgorithm) {
        Integer[] actual = INPUT.clone();
        String message = sortAlgorithm + ": " + Arrays.toString(actual);
        SortUtility sortUtility = new SortUtility().using(sortAlgorithm);

        SortResult sortResult = sortUtility.inAscendingOrder().sort(actual);
        Assert.assertArrayEquals(message, EXPECTED_ASCENDING, sortResult.sortedArray);
        Assert.assertTrue(message, sortResult.comparisonCount >= 0);
        Assert.assertTrue(message, sortResult.swapCount >= 0);

        actual = INPUT.clone();
        sortResult = sortUtility.inDescendingOrder().sort(actual);
        Assert.assertArrayEquals(message, EXPECTED_DESCENDING, sortResult.sortedArray);
        Assert.assertTrue(message, sortResult.comparisonCount > 0);
        Assert.assertTrue(message, sortResult.swapCount >= 0);
    }
}
