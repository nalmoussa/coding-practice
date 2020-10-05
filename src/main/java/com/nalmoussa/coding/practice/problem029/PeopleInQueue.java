package com.nalmoussa.coding.practice.problem029;

/*
Suppose you have a random list of people standing in a queue.
Each person is described by a pair of integers (h, k),
where h is the height of the person and k is the number of people in front of this person who have a height greater
than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class PeopleInQueue {
  private static final int H = 0;
  private static final int K = 1;
  private static final int L = 2;

  public static void main(String[] argv) {
    int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
    printPeople(input);

    int[][] output = reconstructTheQueue(input);
    printPeople(output);
  }

  private static int[][] reconstructTheQueue(int[][] input) {
    int[][] processArray = new int[input.length][3];
    for (int i = 0; i < input.length; i++) {
      processArray[i][H] = input[i][H];
      processArray[i][K] = input[i][K];
      processArray[i][L] = input[i][K];
    }

    for (int i = 0; i < processArray.length; i++) {
      int next = i;
      for (int j = i + 1; j < processArray.length; j++) {
        // find the next person in queue
        next = whosNext(processArray, next, j);
      }

      // swap with the person standing at current index
      swap(processArray, i, next);

      // reduce K (if needed) for remaining people
      for (int j = i + 1; j < processArray.length; j++) {
        if (processArray[i][H] >= processArray[j][H]) {
          processArray[j][K]--;
        }
      }
    }

    int[][] output = new int[input.length][2];
    for (int i = 0; i < input.length; i++) {
      output[i][H] = processArray[i][H];
      output[i][K] = processArray[i][L];
    }
    return output;
  }

  private static int whosNext(int[][] people, int next, int j) {
    if (people[j][K] > 0) {
      return next;
    }

    // people[j][K] = 0 now
    if (people[next][K] > 0) {
      return j;
    }

    // both people[j][K] and people[next][K] = 0
    return (people[j][H] <= people[next][H]) ? j : next;
  }

  private static void swap(int[][] array, int i, int j) {
    if (i != j) {
      int[] temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }

  private static void printPeople(int[][] people) {
    System.out.print("[");
    for (int i = 0; i < people.length; i++) {
      System.out.print("[");
      System.out.print(people[i][H] + "," + people[i][K]);
      String comma = (i == people.length - 1) ? "" : ", ";
      System.out.print("]" + comma);
    }
    System.out.println("]");
  }
}
