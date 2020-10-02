package com.nalmoussa.coding.practice.problem016;

import org.junit.Test;

public class MaxSubarraySumTests {
    @Test
    public void verifyFindMaxSubarraySumWorksAsExpected() {
        int[] array = {-4, 3, -1,  -3, 2, 9};
        MaxSubarraySum.findMax(array);
        System.out.println("===========");
        System.out.println("===========");
        System.out.println("===========");
        MaxSubarraySum.findMaxFast(array);
    }
}
