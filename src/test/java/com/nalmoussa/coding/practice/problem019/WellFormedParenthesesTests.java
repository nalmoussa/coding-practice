package com.nalmoussa.coding.practice.problem019;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class WellFormedParenthesesTests {
    @Test
    public void verifyGenerateWellFormedParenthesesThrowsExceptionWhenPairCountIsNegative() {
        boolean hasException;
        int pairCount = -1;
        try {
            WellFormedParentheses.generateWellFormedParentheses(pairCount);
            hasException = false;
        }
        catch (IllegalArgumentException ex) {
            hasException = true;
        }

        Assert.assertTrue("generateWellFormedParentheses(" + pairCount + ") should throw IllegalArgumentException.", hasException);
    }

    @Test
    public void verifyGenerateWellFormedParenthesesThrowsExceptionWhenPairCountIsZero() {
        boolean hasException;
        int pairCount = 0;
        try {
            WellFormedParentheses.generateWellFormedParentheses(pairCount);
            hasException = false;
        }
        catch (IllegalArgumentException ex) {
            hasException = true;
        }

        Assert.assertTrue("generateWellFormedParentheses(" + pairCount + ") should throw IllegalArgumentException.", hasException);
    }

    @Test
    public void verifyGenerateWellFormedParenthesesReturnsTheRightCount() {
        int[] pairCount = {1, 2, 3, 4};
        int[] expectedCount = {1, 2, 5, 14};
        List<String> wellFormedParentheses;
        String message = "The count of returned parentheses is incorrect";
        for (int i = 0; i < pairCount.length; i++) {
            wellFormedParentheses = WellFormedParentheses.generateWellFormedParentheses(pairCount[i]);
            Assert.assertEquals(message, expectedCount[i], wellFormedParentheses.size());
        }
    }

    @Test
    public void verifyGenerateWellFormedParenthesesReturnsWellFormedParentheses() {
        int pairCount = 4;
        String message;
        List<String> wellFormedParentheses = WellFormedParentheses.generateWellFormedParentheses(pairCount);
        for (String str : wellFormedParentheses) {
            message = "\"" + str + "\" is not well formed parentheses";
            Assert.assertTrue(message, WellFormedParentheses.isWellFormedParentheses(str));
        }
    }

    @Test
    public void verifyIsWellFormedParenthesesDetectsNotWellFormedParentheses() {
        String[] notWellFormedParentheses = {".", "(", ")", ")(", "())"};
        String message;
        for (String str : notWellFormedParentheses) {
            message = "\"" + str + "\" is well formed parentheses";
            Assert.assertFalse(message, WellFormedParentheses.isWellFormedParentheses(str));
        }
    }

    @Test
    public void verifyIsWellFormedParenthesesDetectsWellFormedParentheses() {
        String[] wellFormedParentheses = {"", "()", "(())", "()()", "()(())"};
        String message;
        for (String str : wellFormedParentheses) {
            message = "\"" + str + "\" is not well formed parentheses";
            Assert.assertTrue(message, WellFormedParentheses.isWellFormedParentheses(str));
        }
    }
}
