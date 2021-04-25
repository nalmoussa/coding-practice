package com.nalmoussa.coding.practice.problem044;

/*
Implement a system that when given a value of currency and denominations of coins will calculate the
minimum number of coins to dispense to make change.

Example:
For coins [1, 5, 10, 25]; $0.67 -> [2x25, 1x10, 1x5, 2x1] => 6
For coins [1, 5, 10, 25]; $0.01 -> [0x25, 0x10, 0x5, 1x1]
*/

public class Solution {
  public static int[] findMinCoins(int value) {

    int[] denominations = getDenominations();
    int[] answer = new int[denominations.length];
    int coinIndex = 0;
    while (value > 0) {
      answer[coinIndex] += value / denominations[coinIndex];
      value = value % denominations[coinIndex];
      coinIndex++;
    }
    return answer;
  }

  public static int[] getDenominations() {
    return new int[]{25, 10, 5, 1};
  }

  public static void main(String[] args) {
    int[] answer = findMinCoins(67);
    for (int j : answer) {
      System.out.println(j);
    }
  }
}