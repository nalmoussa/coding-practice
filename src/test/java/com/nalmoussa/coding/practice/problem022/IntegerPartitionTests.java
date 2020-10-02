package com.nalmoussa.coding.practice.problem022;

import org.junit.Assert;
import org.junit.Test;

public class IntegerPartitionTests {
    @Test
    public void verifyIntegerPartitionWorksAsExpected() {
        boolean foundCombination = false;
        int sum = 2000;
        IntegerPartition savedElements = new IntegerPartition(sum);
        long index = 0;
        int newElement;
        while (index++ < Long.MAX_VALUE) {
            newElement = IntegerPartition.next();
            System.out.println(newElement);
            if (savedElements.hasCombination(newElement)) {
                System.out.println("Found combination equals to " + sum + ". Index: " + index);
                foundCombination = true;
                break;
            }
        }

        Assert.assertTrue(foundCombination);
    }
}
