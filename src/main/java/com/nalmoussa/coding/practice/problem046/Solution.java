package com.nalmoussa.coding.practice.problem046;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private static final Map<Integer, Integer> map = new HashMap<>();

  public static void main(String[] args) {
    System.out.println(numTrees(3));
  }

  public static int numTrees(int n) {
    if (!map.containsKey(n)) {
      map.put(n, computeNumTrees(n));
    }

    return map.get(n);
  }

  private static int computeNumTrees(int n) {
    int count = 0;
    if (n <= 1) {
      count = 1;
    } else {
      for (int root = 1; root <= n; root++) {
        count += (long) numTrees(root - 1) * numTrees(n - root);
      }
    }
    return count;
  }
}