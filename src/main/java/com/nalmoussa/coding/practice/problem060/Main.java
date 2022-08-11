package com.nalmoussa.coding.practice.problem060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(List.of(2));
    triangle.add(Arrays.asList(3, 4));
    triangle.add(Arrays.asList(6, 5, 7));
    triangle.add(Arrays.asList(4, 1, 8, 3));

    System.out.println(solution.minimumTotal(triangle));
  }
}
