package com.nalmoussa.coding.practice;

import org.junit.Assert;
import org.junit.Test;

public class RandomnessTests {
    private static int maxIteration = 10000000;
    @Test
    public void verifyRandWorksAsExpected() {
        int[] allowedBase = {2, 4, 5, 6, 7, 9};
        for (int base : allowedBase) {
            try {
                int number = Randomness.rand(base);
                Assert.assertTrue("The returned number is bigger than expected", number <= base);
            }
            catch (Exception ex) {
                Assert.assertEquals("An exception was thrown for an allowed base ", 9, base);
            }
        }
    }

    @Test
    public void verifyRand2WorksAsExpected() {
        int[] array = generateRandomArray(2);
        verifyRandomness(array, 50);
    }

    @Test
    public void verifyRand4WorksAsExpected() {
        int[] array = generateRandomArray(4);
        verifyRandomness(array, 25);
    }

    @Test
    public void verifyRand5WorksAsExpected() {
        int[] array = generateRandomArray(5);
        verifyRandomness(array, 20);
    }

    @Test
    public void verifyRand6WorksAsExpected() {
        int[] array = generateRandomArray(6);
        verifyRandomness(array, 17);
    }

    @Test
    public void verifyRand7WorksAsExpected() {
        int[] array = generateRandomArray(7);
        verifyRandomness(array, 14);
    }

    private int[] generateRandomArray(int base) {
        int[] array =  new int[base];
        for (int i = 0; i < maxIteration; i++) {
            int index = Randomness.rand(base) - 1;
            array[index]++;
        }

        return array;
    }

    private void verifyRandomness(int[] array, int expectedPercentage) {
        double sum = 0;
        double probability;
        long actualPercentage;
        for (int count : array) {
            probability = ((double) count) / maxIteration;
            actualPercentage = Math.round(100 * probability);
            Assert.assertEquals("The distribution is wrong", expectedPercentage, actualPercentage);
            sum += probability;
        }
        Assert.assertEquals("The sum doesn't add up to 1", 1, Math.round(sum));
    }
}
