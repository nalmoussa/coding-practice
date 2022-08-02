package com.nalmoussa.coding.practice.problem058;

import java.util.Random;

public class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] height = generateHeightArray();
    System.out.println("Area1: " + solution.maxArea1(height));
    System.out.println("Area2: " + solution.maxArea2(height));
  }

  private static int[] generateHeightArray() {
    int[] height = new int[71050];
    Random rand = new Random();
    for (int i = 0; i < height.length; i++) {
      height[i] = rand.nextInt(10001);
    }
    return height;
  }
}
