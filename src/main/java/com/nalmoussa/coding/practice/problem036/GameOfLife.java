package com.nalmoussa.coding.practice.problem036;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameOfLife {
  private final int rowCount;
  private final int colCount;
  private boolean [][] world;

  private GameOfLife(String inputFileName) {
    rowCount = 20;
    colCount = 40;
    try {
      File inputFile = new File(inputFileName);
      Scanner scanner = new Scanner(inputFile);
      world = new boolean[rowCount][colCount];
      for (int row = 0; row < rowCount; row++) {
        char[] line = scanner.next().toCharArray();
        for (int col = 0; col < colCount; col++) {
          world[row][col] = (line[col] == '1');
        }
      }
      scanner.close();
    } catch (FileNotFoundException ex) {
      System.out.println("An error occurred while reading the matrix.");
    }
  }

  private boolean stop() {
    String userInput = "none";
    Scanner scanner = new Scanner(System.in);
    while (!"yn".contains(userInput.toLowerCase())) {
      System.out.print("Do you want to continue? (Y/N): ");
      userInput = scanner.next();
    }
    return (userInput.equalsIgnoreCase("n"));
  }

  private void display() {
    for (int row = 0; row < rowCount; row++) {
      for (int col = 0; col < colCount; col++) {
        System.out.print(world[row][col] ? "O" : "-");
      }
      System.out.println();
    }
  }

  private void buildNextGeneration() {
    boolean[][] nextGeneration = new boolean[rowCount][colCount];

    for (int row = 0; row < rowCount; row++) {
      for (int col = 0; col < colCount; col++) {
        int numberOfNeighbors = computeNumberOfNeighbors(row, col);
        nextGeneration[row][col] = willBeAlive(world[row][col], numberOfNeighbors);
      }
    }

    world = nextGeneration;
  }

  private boolean willBeAlive(boolean isAlive, int numberOfNeighbors) {
    if (isAlive && (numberOfNeighbors == 2 || numberOfNeighbors == 3)) {
      return true;
    } else return !isAlive && numberOfNeighbors == 3;
  }

  private int computeNumberOfNeighbors(int row, int col) {
    return isNeighborAlive(row, col, -1,  0)
         + isNeighborAlive(row, col, -1,  1)
         + isNeighborAlive(row, col,  0,  1)
         + isNeighborAlive(row, col,  1,  1)
         + isNeighborAlive(row, col,  1,  0)
         + isNeighborAlive(row, col,  1, -1)
         + isNeighborAlive(row, col,  0, -1)
         + isNeighborAlive(row, col, -1, -1);
  }

  private int isNeighborAlive(int x, int y, int ox, int oy) {
    // Only calculate if in bounds
    if (!(x + ox < 0 || x + ox >= rowCount || y + oy < 0 || y + oy >= colCount)) {
      return world[x + ox][y + oy] ? 1 : 0;
    }
    return 0;
  }

  public static void main(String[] args) {
    String inputFileName = "src/main/java/com/mcg/life/world.txt";
    GameOfLife gameOfLife = new GameOfLife(inputFileName);
    gameOfLife.display();

    while (!gameOfLife.stop()) {
      // Calculate next generation
      gameOfLife.buildNextGeneration();

      // Display world
      gameOfLife.display();
    }
  }
}
