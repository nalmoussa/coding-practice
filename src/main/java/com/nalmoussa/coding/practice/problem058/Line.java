package com.nalmoussa.coding.practice.problem058;

public class Line implements Comparable<Line> {
  public final int height;
  public final int index;

  public Line(int height, int index) {
    this.height = height;
    this.index = index;
  }
  @Override
  public int compareTo(Line other) {
    return Integer.compare(height, other.height);
  }
}