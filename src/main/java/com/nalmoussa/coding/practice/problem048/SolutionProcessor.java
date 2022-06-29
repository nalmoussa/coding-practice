package com.nalmoussa.coding.practice.problem048;

public class SolutionProcessor {
  private LRUCache cache;

  public Integer[] process(Command[] inputCommands, int[][] inputValues) {
    if (inputCommands == null || inputValues == null) {
      throw new IllegalArgumentException("Invalid Input Arguments");
    }

    Integer[] output = new Integer[inputCommands.length];
    for (int i = 0; i < inputCommands.length; i++) {
      output[i] = process(inputCommands[i], inputValues[i]);
    }
    return output;
  }

  private Integer process(Command inputCommand, int[] inputValues) {
    Integer output = null;
    switch (inputCommand) {
      case LRU_CACHE:
        cache = new LRUCache(inputValues[0]);
        break;
      case PUT:
        cache.put(inputValues[0], inputValues[1]);
        break;
      case GET:
        output = cache.get(inputValues[0]);
        break;
    }
    return output;
  }
}
