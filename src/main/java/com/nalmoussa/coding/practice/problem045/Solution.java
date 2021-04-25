package com.nalmoussa.coding.practice.problem045;

/*
Integer to English Words

Convert a non-negative integer num to its English words representation.

Example 1:
Input: num = 123
Output: "One Hundred Twenty Three"

Example 2:
Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:
Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:
Input: num = 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

Constraints:
0 <= num <= 2^31 - 1 = 2147483647

*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private static final Map<Integer, String> numberMap = new HashMap<>();
  private static final Map<Integer, String> unitMap = new HashMap<>();
  static {
    numberMap.put(0, "Zero");
    numberMap.put(1, "One");
    numberMap.put(2, "Two");
    numberMap.put(3, "Three");
    numberMap.put(4, "Four");
    numberMap.put(5, "Five");
    numberMap.put(6, "Six");
    numberMap.put(7, "Seven");
    numberMap.put(8, "Eight");
    numberMap.put(9, "Nine");
    numberMap.put(10, "Ten");
    numberMap.put(11, "Eleven");
    numberMap.put(12, "Twelve");
    numberMap.put(13, "Thirteen");
    numberMap.put(14, "Fourteen");
    numberMap.put(15, "Fifteen");
    numberMap.put(16, "Sixteen");
    numberMap.put(17, "Seventeen");
    numberMap.put(18, "Eighteen");
    numberMap.put(19, "Nineteen");
    numberMap.put(20, "Twenty");
    numberMap.put(30, "Thirty");
    numberMap.put(40, "Forty");
    numberMap.put(50, "Fifty");
    numberMap.put(60, "Sixty");
    numberMap.put(70, "Seventy");
    numberMap.put(80, "Eighty");
    numberMap.put(90, "Ninety");

    unitMap.put(100, "Hundred");
    unitMap.put(1000, "Thousand");
    unitMap.put(1000000, "Million");
    unitMap.put(1000000000, "Billion");
  }

  public static String convertToString(int input) {
    if (numberMap.containsKey(input)) {
      return numberMap.get(input);
    }

    int unit = 1000000000;
    while ((input / unit) == 0) {
      unit /= (unit <= 1000) ? 10 : 1000;
    }

    int largePart = input / unit;
    int smallPart = input % unit;

    String largePartStr = (unit == 10) ? convertToString(largePart * 10) : convertToString(largePart);
    String unitStr = (unit == 10) ? "" : " " + unitMap.get(unit);
    String smallPartStr = (smallPart == 0) ? "" : " " + convertToString(smallPart);

    return largePartStr + unitStr + smallPartStr;
  }
}