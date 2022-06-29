package com.nalmoussa.coding.practice.problem048;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  public static void main(String[] args) {
//    run();
    test();
  }

  private static void run() {
    Command[] inputCommands = {
        Command.LRU_CACHE,
        Command.PUT,
        Command.PUT,
        Command.GET,
        Command.GET,
        Command.PUT,
        Command.GET,
        Command.GET,
        Command.GET
    };

    int[][] inputValues = {
        {2},
        {2,1},
        {3,2},
        {3},
        {2},
        {4,3},
        {2},
        {3},
        {4}
    };

    Integer[] expected = {null, null, null, 2, 1, null, 1, -1, 3};

    SolutionProcessor processor = new SolutionProcessor();
    Integer[] output = processor.process(inputCommands, inputValues);

    int index = assertEquals(expected, output);
    if (index > 0) {
      System.out.println("Failed Assertion: ");
      System.out.println("Command: " + inputCommands[index]);
      System.out.println("Input: " + Arrays.toString(inputValues[index]));
      System.out.println("Index: " + (index + 1));
      System.out.println("Expected: " + expected[index] + ", Actual: " + output[index]);
    } else {
      System.out.println("Success!!");
    }
  }

  private static int assertEquals(Integer[] expected, Integer[] output) {
    if (expected == null || output == null || expected.length != output.length) {
      throw new IllegalArgumentException("Invalid Input Arguments");
    }

    for (int i = 0; i < expected.length; i++) {
      Integer expectedValue = expected[i];
      Integer outputValue = output[i];
      if (Objects.equals(expectedValue, outputValue)) continue;
      return i;
    }

    return -1;
  }

  private static void test() {
    Queue<Integer> testIntegersPQ = new PriorityQueue<>();
    testIntegersPQ.add(11);
    testIntegersPQ.add(5);
    testIntegersPQ.add(1);
    testIntegersPQ.add(12);
    testIntegersPQ.add(6);

    System.out.println("Integers stored in reverse order of priority in a Priority Queue\n");
    while (!testIntegersPQ.isEmpty()) {
      System.out.println(testIntegersPQ.poll());
    }
  }
}
