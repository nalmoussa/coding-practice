package com.nalmoussa.coding.practice.problem045;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void verifyConvertToWordRepresentationWorksAsExpectedWithValidInput() {
    final int[] inputList = {0, 100, 123, 1000, 10000, 12345, 1234567, 100000000, 1234567891, 2147483647};
    final String[] expectedList = {
        "Zero",
        "One Hundred",
        "One Hundred Twenty Three",
        "One Thousand",
        "Ten Thousand",
        "Twelve Thousand Three Hundred Forty Five",
        "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
        "One Hundred Million",
        "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",
        "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven"
    };

    for (int i = 0; i < inputList.length; i++) {
      int input = inputList[i];
      String expected = expectedList[i];
      String actual = Solution.convertToString(input);
      Assert.assertEquals("convertToWordRepresentation failed to convert the number",
          expected,
          actual);
      System.out.println(input + ": " + actual);
    }
  }
}
