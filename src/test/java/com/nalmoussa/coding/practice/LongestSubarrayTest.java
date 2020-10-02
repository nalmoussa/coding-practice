package com.nalmoussa.coding.practice;

import org.junit.Test;

public class LongestSubarrayTest {
    @Test
    public void verifyFindLongestSubarrayWorksAsExpected() {
        int[] array = {60, 15, 75, 56, 61, 31, 60, 98, 32, 14};
        int[] factors = {3, 4, 5, 2};

        int length     = LongestSubarray.findLongestSubarray(array, factors);
        System.out.println(length);
    }
}
