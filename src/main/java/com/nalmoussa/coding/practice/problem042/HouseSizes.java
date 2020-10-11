package com.nalmoussa.coding.practice.problem042;

/*
You are given an NxM grid representing a map. The grid will contain 0s and 1s,
where 0s represent empty land, and 1s represent houses. 1s that are connected
horizontally or vertically represent a single house that covers multiple plots of land.
Write a function that will take a grid and return the area of the largest house.

For example, given this grid:

0,0,1,1,0,0
0,0,0,1,0,1
0,0,0,0,0,1
0,1,1,0,0,0
0,1,1,1,0,0
0,0,0,0,0,0

The area of the largest house is 5

*/


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class HouseSizes {
  public static void main(String[] args) {
    int[][] inputMap = {
        {0,0,1,1,0,0},
        {0,0,0,1,0,1},
        {0,0,0,0,0,1},
        {0,1,1,0,0,0},
        {0,1,1,1,0,0},
        {0,0,0,0,0,0}};
    System.out.println(findLargestHouse(inputMap));
  }

  private static int findLargestHouse(int[][] map) {
    int maxHouseSize = 0;

    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < map[0].length; col++) {
        if (map[row][col] == 1) {
          int houseSize = getHouseSize(map, row, col);
          if (houseSize > maxHouseSize) {
            maxHouseSize = houseSize;
          }
        }
      }
    }

    return maxHouseSize;
  }

  private static int getHouseSize(int[][] map, int row, int col) {
    int size = 0;
    if (isValid(map, row, col) && map[row][col] == 1) {
      map[row][col] = 0;
      size = 1
          + getHouseSize(map, row - 1, col)
          + getHouseSize(map, row + 1, col)
          + getHouseSize(map, row, col - 1)
          + getHouseSize(map, row, col + 1);
    }

    return size;
  }

  private static boolean isValid(int[][] map, int row, int col) {
    boolean rowValid = (row >= 0) && (row < map.length);
    boolean colValid = (col >= 0) && (col < map[0].length);

    return rowValid && colValid;
  }
}
