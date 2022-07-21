package com.nalmoussa.coding.practice.problem056;

public class Solution {
  private static String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
  private static int[]     values = {1000,  900, 500,  400, 100,   90,  50,   40,  10,    9,   5,    4,   1};

  public String intToRoman(int num) {
    StringBuilder result = new StringBuilder();
    for (int index = 0; ((index < symbols.length) && (num > 0)); index++) {
      int count = num / values[index];
      for (int i = 0; i < count; i++) {
        result.append(symbols[index]);
      }
      num -= count * values[index];
    }

    return result.toString();
  }
}
