package com.nalmoussa.coding.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargeNumberTests {
    @Test
    public void verifyMultiplyByIntWorksAsExpected() {
        LargeNumber largeNumber = new LargeNumber("58");
        LargeNumber result = largeNumber.multiply(2);
        assertEquals("They should be equal numbers", "116", result.toString());
    }

    @Test
    public void verifyMultiplyByAnotherLargeNumberWorksAsExpected() {
        String String1 = "11290123534345354345664646464887878564536756756756334564564575765756757575757567858568678678678678676787575676754534534535345534543533";
        String String2 = "453236345353458";
        LargeNumber largeNumber1 = new LargeNumber(String1);
        LargeNumber largeNumber2 = new LargeNumber(String2);

        LargeNumber largeNumber3 = new LargeNumber(String1);
        LargeNumber largeNumber4 = new LargeNumber(String2);

        String result1 = largeNumber1.multiply(largeNumber2).toString();
        String result2 = largeNumber3.multiplyFast(largeNumber4).toString();

        System.out.println(result1);
        System.out.println(result2);
        assertEquals("They should be equal numbers", result1, result2);
    }

    @Test
    public void verifyMultiplyByPowerOfTenWorksAsExpected() {
        LargeNumber largeNumber = new LargeNumber("58");
        LargeNumber result = largeNumber.multiplyByPowerOfTen(2);
        assertEquals("They should be equal numbers", "5800", result.toString());
    }

    @Test
    public void verifyAddWorksAsExpected() {
        LargeNumber largeNumber1 = new LargeNumber("5800");
        LargeNumber largeNumber2 = new LargeNumber("5800");
        LargeNumber result = largeNumber1.add(largeNumber2);
        assertEquals("They should be equal numbers", largeNumber2.multiply(2).toString(), result.toString());
    }
}
