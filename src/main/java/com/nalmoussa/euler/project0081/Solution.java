package com.nalmoussa.euler.project0081;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
  // Find the minimal path sum from the top left to the bottom right
  // by only moving right and down
  public static void main(String[] args) {
    String matrixFileName = "src/main/java/com/nalmoussa/euler/project0081/matrix.txt";
    int[][] matrix = readMatrix(matrixFileName);
    printMatrix(matrix);

    long minimalPathRecursively = findMinimalPathRecursively(matrix, 0, 0);
    long minimalPathByMemoization = findMinimalPathByMemoization(matrix, createMemoizationMatrix(matrix), 0, 0);
    long minimalPathUsingDP = findMinimalPathUsingDP(matrix);

    System.out.println();
    System.out.println("Recursively: " + minimalPathRecursively);
    System.out.println("By Memoization: " + minimalPathByMemoization);
    System.out.println("Using DP: " + minimalPathUsingDP);
  }

  private static int[][] readMatrix(String matrixFileName) {
    if (matrixFileName == null) {
      return new int[][]
          {{131, 673, 234, 103, 18},
              {201, 96, 342, 965, 150},
              {630, 803, 746, 422, 111},
              {537, 699, 497, 121, 956},
              {805, 732, 524, 37, 331}};
    }

    int rowCount = 80;
    int colCount = 80;
    int[][] matrix = null;
    try {
      File matrixFile = new File(matrixFileName);
      Scanner scanner = new Scanner(matrixFile);
      matrix = new int[rowCount][colCount];

      for (int row = 0; row < rowCount; row++) {
        String[] rowValues =scanner.next().split(",");
        for (int col = 0; col < colCount; col++) {
          matrix[row][col] = Integer.parseInt(rowValues[col]);
        }
      }
    } catch (FileNotFoundException ex) {
      System.out.println("An error occurred while reading the matrix.");
    }

    return matrix;
  }

  private static void printMatrix(int[][] matrix) {
    int colCount = matrix[0].length;

    for (int[] row : matrix) {
      for (int col = 0; col < colCount; col++) {
        System.out.print(row[col] + " ");
      }
      System.out.println();
    }
  }

  private static Long[][] createMemoizationMatrix(int[][] matrix) {
    return new Long[matrix.length][matrix[0].length];
  }

  private static long findMinimalPathRecursively(int[][] matrix, int row, int col) {
    long minimalPath = matrix[row][col];
    int lastRow = matrix.length - 1;
    int lastCol = matrix[0].length - 1;
    if ((row == lastRow) && (col == lastCol)) {
      return minimalPath;
    }

    int nextRow = row + 1;
    int nextCol = col + 1;
    long pathMovingRight = (nextCol <= lastCol) ? findMinimalPathRecursively(matrix, row, nextCol) : Long.MAX_VALUE;
    long pathMovingDown = (nextRow <= lastRow) ? findMinimalPathRecursively(matrix, nextRow, col) : Long.MAX_VALUE;

    minimalPath += Math.min(pathMovingRight, pathMovingDown);
    return minimalPath;
  }

  private static long findMinimalPathByMemoization(int[][] matrix, Long[][] memoizationMatrix, int row, int col) {
    long minimalPath = matrix[row][col];
    int lastRow = matrix.length - 1;
    int lastCol = matrix[0].length - 1;
    if ((row == lastRow) && (col == lastCol)) {
      memoizationMatrix[row][col] = minimalPath;
    }

    if (memoizationMatrix[row][col] == null) {
      int nextRow = row + 1;
      int nextCol = col + 1;
      long pathMovingRight =
          (nextCol <= lastCol) ? findMinimalPathByMemoization(matrix, memoizationMatrix, row, nextCol) : Long.MAX_VALUE;
      long pathMovingDown =
          (nextRow <= lastRow) ? findMinimalPathByMemoization(matrix, memoizationMatrix, nextRow, col) : Long.MAX_VALUE;

      minimalPath += Math.min(pathMovingRight, pathMovingDown);
      memoizationMatrix[row][col] = minimalPath;
    }

    return memoizationMatrix[row][col];
  }

  private static long findMinimalPathUsingDP(int[][] matrix) {
    int rowCount = matrix.length;
    int colCount = matrix[0].length;

    long[] column = new long[rowCount + 1];
    for (int row = rowCount; row >= 0; row--) {
      column[row] = Long.MAX_VALUE;
    }

    column[rowCount - 1] = 0;

    for (int col = colCount - 1; col >= 0; col--) {
      for (int row = rowCount - 1; row >= 0; row--) {
        column[row] = matrix[row][col] + Math.min(column[row + 1], column[row]);
      }
    }

    return column[0];
  }
}
