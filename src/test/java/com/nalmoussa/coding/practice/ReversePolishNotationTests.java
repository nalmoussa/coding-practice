package com.nalmoussa.coding.practice;

import org.junit.Assert;
import org.junit.Test;

public class ReversePolishNotationTests {
    @Test
    public void verifyProcessingChemicalFormulaWorksAsExpected() {
        String[] input1 = {"2", "1", "+"};
        String[] input2 = {"4", "13", "5", "/", "+"};
        String[] input3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] input4 = {"5", "5", "5", "/", "/", "5", "-"};

        String[][] inputList = {input1, input2, input3, input4};
        int[] expectedAnswer = {3, 6, 22, 0};

        for (int index = 0; index < inputList.length; index++) {
            Assert.assertEquals("Invalid evaluation for input " + (index+1), expectedAnswer[index], ReversePolishNotation.evaluate(inputList[index]));
        }
    }
}
