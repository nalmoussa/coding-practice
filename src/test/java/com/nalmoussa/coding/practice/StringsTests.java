package com.nalmoussa.coding.practice;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StringsTests {
    @Test
    public void verifyIsPositiveAcceptsValidPositiveNumbersWithNoSign() {
        String[] numbers = {"32", "10", "0", "10002", "7"};
        int unexpectedIndex = getIndexOfFirstUnexpectedItem(numbers, false, false);
        boolean success = (unexpectedIndex < 0);
        String unexpectedNumber =  success ? "" : numbers[unexpectedIndex];
        String message = unexpectedNumber + " is not valid integer";
        assertTrue(message, success);
    }

    @Test
    public void verifyisPositiveRejectsInvalidNumbersWithNoSign() {
        String[] numbers = {"+", "-", "00", "01", "", "-1", "+1", "e", "100s"};
        int unexpectedIndex = getIndexOfFirstUnexpectedItem(numbers, false, true);
        boolean success = (unexpectedIndex < 0);
        String unexpectedNumber =  success ? "" : numbers[unexpectedIndex];
        String message = unexpectedNumber + " is valid integer";
        assertTrue(message, success);
    }

    @Test
    public void verifyisPositiveAcceptsValidPositiveNumbersWithSign() {
        String[] numbers = {"-32", "+10", "0", "10002", "7", "-7", "+7"};
        int unexpectedIndex = getIndexOfFirstUnexpectedItem(numbers, true, false);
        boolean success = (unexpectedIndex < 0);
        String unexpectedNumber =  success ? "" : numbers[unexpectedIndex];
        String message = unexpectedNumber + " is not valid integer";
        assertTrue(message, success);
    }

    @Test
    public void verifyisPositiveRejectsInvalidNumbersWithSign() {
        String[] numbers = {"+", "-", "00", "01", "", "-0", "+0", "e", "100s", "--1", "+-1", "-+1", "1+1", "1-", "-07", "0-1"};
        int unexpectedIndex = getIndexOfFirstUnexpectedItem(numbers, true, true);
        boolean success = (unexpectedIndex < 0);
        String unexpectedNumber =  success ? "" : numbers[unexpectedIndex];
        String message = unexpectedNumber + " is valid integer";
        assertTrue(message, success);
    }

    private int getIndexOfFirstUnexpectedItem(String[] numbers, boolean allowSign, boolean unexpectedResult) {
        int unexpectedIndex = -1;
        for (int index = 0; index < numbers.length; index++) {
            if (Strings.isInteger(numbers[index], allowSign) == unexpectedResult) {
                unexpectedIndex = index;
                break;
            }
        }
        return unexpectedIndex;
    }
}
