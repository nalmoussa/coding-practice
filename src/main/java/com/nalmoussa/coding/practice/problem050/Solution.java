package com.nalmoussa.coding.practice.problem050;

import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    int[] nums = {3, 9, 10, 8};
    int result = maxCoins(nums);
//    System.out.println(result);
  }

  private static int maxCoins(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      int[] remainingNums = findRemainingNums(i, nums);
      int currentCoins = calculateCoins(i, nums);
      int maxOfRemaining = maxCoins(remainingNums);
      max = Math.max(max, currentCoins + maxOfRemaining);
    }
    return max;
  }

  private static int calculateCoins(int i, int[] nums) {
    int left = (i == 0) ? 1 : nums[i-1];
    int right = (i == (nums.length-1)) ? 1 : nums[i+1];
    return left * nums[i] * right;
  }

  private static int[] findRemainingNums(int i, int[] nums) {
    int[] newNums = new int[nums.length - 1];
    for (int j = 0; j < newNums.length; j++) {
      newNums[j] = (j >= i) ? nums[j+1] : nums[j];
    }
    return newNums;
  }

  private static void printArray(int[] nums) {
    System.out.println(Arrays.toString(nums));
  }
}
