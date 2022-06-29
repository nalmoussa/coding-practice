package com.nalmoussa.coding.practice.problem047;

public class Solution {
  public static void main(String[] args) {
    int[] numbers = {1, 2, 0};
    System.out.println(firstMissingPositive(numbers));
  }

  private static int firstMissingPositive(int[] numbers) {
    int length = numbers.length;
    boolean[] pos = new boolean[length]; // default to false
    for (int number : numbers) {
      if ((number > 0) && (number < length + 1)) {
        pos[number - 1] = true;
      }
    }
    // find the first false position
    for (int index = 0; index < length; index++) {
      if (!pos[index]) {
        return (index + 1);
      }
    }
    return length + 1;
  }
}