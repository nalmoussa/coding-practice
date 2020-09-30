package com.nalmoussa;

import java.util.Random;

public class DiagonalTraversal {
  static Random random = new Random();

  public static void main(String[] args) {
    int[][] array = generateRandomArray(3, 8);
    Print(array);
    PrintDiagonalTraverse(array);
  }

  private static int[][] generateRandomArray(int rowCount, int colCount) {
    int minValue = 1;
    int maxValue = 100;
    int[][] array = new int[rowCount][colCount];
    for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
      for (int colIndex = 0; colIndex < colCount; colIndex++) {
        array[rowIndex][colIndex] = random.nextInt(maxValue) + minValue;
      }
    }

    return array;
  }

  private static void Print(int[][] array) {
    for (int[] ints : array) {
      for (int col = 0; col < array[0].length; col++) {
        System.out.print(ints[col] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  static void PrintDiagonalTraverse(int[][] array) {
    int rowCount = array.length;
    int colCount = array[0].length;
    int diagonalCount =  rowCount + colCount - 1;

    for (int diagonalIndex = 0; diagonalIndex < diagonalCount; diagonalIndex++) {
      int rowIndex = Math.min(diagonalIndex, rowCount - 1);
      int colIndex = diagonalIndex - rowIndex;

      while (isValid(rowIndex, rowCount) && isValid(colIndex, colCount)) {
        System.out.print(array[rowIndex][colIndex] + " ");
        rowIndex--;
        colIndex++;
      }
      System.out.println();
    }
  }

  private static boolean isValid(int n, int max) {
    int min = -1;
    return (n > min) && (n < max);
  }
}
