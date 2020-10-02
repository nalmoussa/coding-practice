package com.nalmoussa.coding.practice.problem014;

import java.util.ArrayList;
import java.util.List;

public class ShapeInGraph {
  public static class RectangleInfo {
    public int x,y;
    public int width, height;
  }

  public static void main(String[] args) {
    int[][] image = new int[][] {
        {1, 0, 0, 0, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 0, 0, 0, 1},
        {1, 1, 1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1},
    };

    ShapeInGraph graph = new ShapeInGraph();
    List<RectangleInfo> rectangleInfos = graph.findRectangles(image);
    for (RectangleInfo rectangleInfo : rectangleInfos) {
      System.out.print(rectangleInfo.x + ", " + rectangleInfo.y + "; ");
      System.out.println(rectangleInfo.width + ", " + rectangleInfo.height);
      System.out.println();
    }
  }

  private List<RectangleInfo> findRectangles(int[][] image) {
    // Validate the image
    boolean[][] visited = new boolean[image.length][image[0].length];
    List<RectangleInfo> rectangleInfos = new ArrayList<>();


    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[0].length; col++) {
        if (!visited[row][col] && image[row][col] == 0) {
          RectangleInfo rectangleInfo = findRectangle(image, visited, row, col);
          rectangleInfos.add(rectangleInfo);
          for (int r = row; r < row + rectangleInfo.height; r++) {
            for (int c = col; c < col + rectangleInfo.width; c++) {
              visited[r][c] = true;
            }
          }
        }
      }
    }
    return rectangleInfos;
  }

  private RectangleInfo findRectangle(int[][] image, boolean[][] visited, int row, int col) {
    RectangleInfo rectangleInfo = new RectangleInfo();
    rectangleInfo.x = row;
    rectangleInfo.y = col;
    rectangleInfo.width = getRectangleWidth(image, row, col);
    rectangleInfo.height = getRectangleHeight(image, row, col);
    return rectangleInfo;
  }

  private void fillVisited(boolean[][] visited, int row, int col, int width, int height) {
    for (int r = row; r < width; r++) {
      for (int c = col; c < height; c++) {
        visited[r][c] = true;
      }
    }
  }

  private int getRectangleWidth(int[][] image, int row, int col) {
    int width = 0;
    while (col < image[0].length && image[row][col] == 0) {
      width++;
      col++;
    }
    return width;
  }

  private int getRectangleHeight(int[][] image, int row, int col) {
    int height = 0;
    while (row < image.length && image[row][col] == 0) {
      height++;
      row++;
    }
    return height;
  }
}
