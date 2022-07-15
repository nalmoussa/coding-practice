package com.nalmoussa.coding.practice.problem054;

public class Solution {
  public String convert(String s, int numRows) {
    numRows = Math.min(numRows, s.length());

    String[] rows = new String[numRows];
    for (int index = 0; index < numRows; index++) {
      rows[index] = "";
    }

    int rowIndex = 0;
    int step = -1;
    for (int i = 0; i < s.length(); i++) {
      String c = s.substring(i, i+1);
      rows[rowIndex] += c;

      if (rowIndex == 0 || rowIndex == (numRows - 1)) {
        step *= -1;
      }
      rowIndex = Math.max(0, Math.min(rowIndex + step, numRows - 1));
    }

    return String.join("", rows);
  }
}
