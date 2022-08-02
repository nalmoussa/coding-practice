package com.nalmoussa.coding.practice.problem057;

public class Solution {
  public int myAtoi(String s) {
    int index = 0;
    // Trim leading whitespace.
    while ((index < s.length()) && (s.charAt(index) == ' ')) {
      index++;
    }

    // Read the sign
    boolean isPositive = true;
    if ((index < s.length()) && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
      isPositive = (s.charAt(index) == '+');
      index++;
    }

    // Read the absolute number
    long number = 0;
    while ((index < s.length()) && (s.charAt(index) >= '0' && s.charAt(index) <= '9') && (number - 1 < Integer.MAX_VALUE)) {
      number *= 10;
      number += s.charAt(index) - '0';
      index++;
    }

    // Clamp
    if (number -1 >= Integer.MAX_VALUE) {
      return (isPositive) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }

    return (isPositive) ? (int)number : -1 * (int)number;
  }
}
