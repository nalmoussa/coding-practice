package com.nalmoussa.coding.practice.problem058;

import java.util.PriorityQueue;

public class Solution {
  public int maxArea(int[] height) {
//    return maxArea1(height);
    return maxArea2(height);
  }

  public int maxArea1(int[] height) {
    int area = 0;
    for (int firstLine = 0; firstLine < height.length - 1; firstLine++) {
      for (int secondLine = firstLine + 1; secondLine < height.length; secondLine++) {
        area = Math.max(area, Math.min(height[firstLine], height[secondLine]) * (secondLine - firstLine));
      }
    }
    return area;
  }

  public int maxArea2(int[] height) {
    PriorityQueue<Line> sortedLines = new PriorityQueue<>();
    for (int index = 0; index < height.length; index++) {
      sortedLines.add(new Line(height[index], index));
    }

    int leftIndex = 0;
    int rightIndex = height.length - 1;
    int area = 0;
    Line line;

    while (!sortedLines.isEmpty()) {
      line = sortedLines.poll();
      while (height[leftIndex] < line.height) {
        leftIndex++;
      }
      while (height[rightIndex] < line.height) {
        rightIndex--;
      }
      if (leftIndex >= rightIndex) {
        break;
      }
      area = Math.max(area, Math.max(line.index - leftIndex, rightIndex - line.index) * line.height);
    }

    return area;
  }
}
