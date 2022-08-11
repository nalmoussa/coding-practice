package com.nalmoussa.coding.practice.problem060;

import java.util.List;

public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    List<Integer> lastRow = triangle.get(triangle.size()-1);
    Integer[] minimums = lastRow.toArray(new Integer[0]);
    if (triangle.size() > 1) {
      for (int index = triangle.size() - 2; index >= 0; index--) {
        List<Integer> row = triangle.get(index);
        for (int i = 0; i < row.size(); i++) {
          minimums[i] = row.get(i) + Math.min(minimums[i], minimums[i+1]);
        }
      }
    }

    return minimums[0];
  }
}
