package com.nalmoussa.coding.practice;

import org.junit.Assert;
import org.junit.Test;

public class ChemicalFormulaTests {
    @Test
    public void verifyConstructorThrowsExceptionWhenInputIsInvalid() {
        String[] invalidInput = {null, "", Strings.generateLongString(1010, 'x'), "(H2O))", "(*H2O)", "( H2O)"};
        boolean hasException = false;
        String invalidFormula = "";
        for (String input : invalidInput) {
            try {
                new ChemicalFormula(input);
                hasException = false;
                invalidFormula = input;
                break;
            }
            catch (IllegalArgumentException ex) {
                hasException = true;
            }
        }

        if (invalidFormula != null) {
            invalidFormula = "\"" + invalidFormula + "\"";
        }
        String assertMessage = "ChemicalFormula(" + invalidFormula + ") should throw IllegalArgumentException.";
        Assert.assertTrue(assertMessage, hasException);
    }

    @Test
    public void verifyProcessingChemicalFormulaWorksAsExpected() {
        String input = "(((H2O)4NiS4(K)))F";
        ChemicalFormula chemicalFormula = new ChemicalFormula(input);
        System.out.println("Answer is: " + chemicalFormula.getNumberOfAtoms());
    }
}