package com.nalmoussa;

import org.junit.Assert;
import org.junit.Test;

public class LookAndSayTests {
    private String[] invalidInput  = {" ", "0", "d", "1233s", "!"};
    private String[] validInput    = {null,  "",  "1",  "2",    "121", "11111",     "1234"};
    private String[] expected = { "1", "1", "11", "12", "111211",    "51", "11121314"};

    @Test
    public void verifyNextThrowsIllegalArgumentExceptionWhenNumIsInvalid() {
        boolean hasException = false;
        String invalidNumber = "";
        for (String num : invalidInput) {
            try {
                LookAndSay.next(num);
                hasException = false;
                invalidNumber = num;
                break;
            }
            catch (IllegalArgumentException ex) {
                hasException = true;
            }
        }

        Assert.assertTrue("next(\"" + invalidNumber + "\") should throw IllegalArgumentException.", hasException);
    }

    @Test
    public void verifyNextWorksAsExpected() {
        for (int i = 0; i < validInput.length; i++) {
            verifyNextWorksAsExpected(validInput[i], expected[i]);
        }
    }

    private void verifyNextWorksAsExpected(String input, String expected) {
        String actual = LookAndSay.next(input);
        Assert.assertTrue("Expected: " + expected + ". Actual = " + actual, (expected.equals(actual)));
    }
}
