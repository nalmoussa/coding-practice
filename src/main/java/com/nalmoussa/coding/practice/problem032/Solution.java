package com.nalmoussa.coding.practice.problem032;

import java.util.*;

/*
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations.
The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

Write a function that takes the graph as its input and returns two lists as its output. The first list has all individuals
with zero parent. The second list has all individuals with exactly one parent.

         14  13
         |   |
1   2    4   12
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7     11

parentChildPairs = [
    (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
    (4, 8), (4, 9), (9, 11), (14, 4), (13, 12), (12, 9)
]

In this diagram, [1, 2, 13, 14] are individuals with zero parents, and [4, 5, 7, 8, 11, 12] are individuals with exactly
one parent.

Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true
if and only if they share at least one ancestor.

For example, in this diagram, 6 and 8 have common ancestors of 4 and 14.

         14  13
         |   |
1   2    4   12
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7     11

parentChildPairs1 = [
    (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
    (4, 8), (4, 9), (9, 11), (14, 4), (13, 12), (12, 9)
]

Sample input and output:

hasCommonAncestor(parentChildPairs1, 3, 8) => false
hasCommonAncestor(parentChildPairs1, 5, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 9) => true
hasCommonAncestor(parentChildPairs1, 1, 3) => false
hasCommonAncestor(parentChildPairs1, 3, 1) => false
hasCommonAncestor(parentChildPairs1, 7, 11) => true
hasCommonAncestor(parentChildPairs1, 6, 5) => true
hasCommonAncestor(parentChildPairs1, 5, 6) => true

Additional example: In this diagram, 4 and 12 have a common ancestor of 11.

        11
       /  \
      10   12
     /  \
1   2    5
 \ /    / \
  3    6   7
   \        \
    4        8

parentChildPairs2 = [
    (11, 10), (11, 12), (2, 3), (10, 2), (10, 5),
    (1, 3), (3, 4), (5, 6), (5, 7), (7, 8),
]

hasCommonAncestor(parentChildPairs2, 4, 12) => true
hasCommonAncestor(parentChildPairs2, 1, 6) => false
hasCommonAncestor(parentChildPairs2, 1, 12) => false

n: number of pairs in the input
*/
public class Solution {
  public static void main(String[] args) {
    firstQuestion();
    secondQuestion();
  }

  private static void firstQuestion() {
    int[][] parentChildPairs = new int[][] {
        {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
        {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}
    };

    List<List<Integer>> output = findNodesWithZeroAndOneParents(parentChildPairs);
    printList(output.get(0));
    System.out.println("=======");
    printList(output.get(1));
  }

  private static void secondQuestion() {
    int[][] parentChildPairs1 = new int[][] {
        {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
        {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}
    };
    System.out.println(hasCommonAncestor(parentChildPairs1, 3, 8));
    System.out.println(hasCommonAncestor(parentChildPairs1, 5, 8));
    System.out.println(hasCommonAncestor(parentChildPairs1, 6, 8));
    System.out.println(hasCommonAncestor(parentChildPairs1, 6, 9));
    System.out.println(hasCommonAncestor(parentChildPairs1, 1, 3));
    System.out.println(hasCommonAncestor(parentChildPairs1, 3, 1));
    System.out.println(hasCommonAncestor(parentChildPairs1, 7, 11));
    System.out.println(hasCommonAncestor(parentChildPairs1, 6, 5));
    System.out.println(hasCommonAncestor(parentChildPairs1, 5, 6));

    int[][] parentChildPairs2 = new int[][] {
        {11, 10}, {11, 12}, {2, 3}, {10, 2}, {10, 5},
        {1, 3}, {3, 4}, {5, 6}, {5, 7}, {7, 8}
    };
    System.out.println(hasCommonAncestor(parentChildPairs2, 4, 12));
    System.out.println(hasCommonAncestor(parentChildPairs2, 1, 6));
    System.out.println(hasCommonAncestor(parentChildPairs2, 1, 12));
  }

  private static List<List<Integer>> findNodesWithZeroAndOneParents(int[][] parentChildPairs) {
    Map<Integer, List<Integer>> parentMap = createParentMap(parentChildPairs);

    List<Integer> zeroParents = new ArrayList<>();
    List<Integer> exactlyOneParent = new ArrayList<>();

    for (Integer child : parentMap.keySet()) {
      int parentCount = parentMap.get(child).size();
      if (parentCount == 0) {
        zeroParents.add(child);
      } else if (parentCount == 1) {
        exactlyOneParent.add(child);
      }
    }

    List<List<Integer>> output = new ArrayList<>();
    output.add(zeroParents);
    output.add(exactlyOneParent);

    return output;
  }

  private static Map<Integer, List<Integer>> createParentMap(int[][] parentChildPairs) {
    Map<Integer, List<Integer>> parentMap = new HashMap<>();
    for (int[] pair : parentChildPairs) {
      int parent = pair[0];
      int child = pair[1];

      List<Integer> parentList = parentMap.getOrDefault(child, new ArrayList<>());
      parentList.add(parent);
      parentMap.put(child, parentList);

      if (!parentMap.containsKey(parent)) {
        parentMap.put(parent, new ArrayList<>());
      }
    }

    return parentMap;
  }

  private static boolean hasCommonAncestor(int[][] parentChildPairs, int child1, int child2) {
    Map<Integer, List<Integer>> parentMap = createParentMap(parentChildPairs);

    Set<Integer> ancestor1 = findAllAncestors(parentMap, child1);
    Set<Integer> ancestor2 = findAllAncestors(parentMap, child2);

    return hasCommonElement(ancestor1, ancestor2);
  }

  private static boolean hasCommonElement(Set<Integer> set1, Set<Integer> set2) {
    for (Integer element : set1) {
      if (set2.contains(element)) {
        return true;
      }
    }
    return false;
  }

  private static Set<Integer> findAllAncestors(Map<Integer, List<Integer>> parentMap, int child) {
    Set<Integer> result = new HashSet<>();
    List<Integer> parents = parentMap.get(child);

    // for each parents, add it to the result set
    for (Integer parent : parents) {
      result.add(parent);
      result.addAll(findAllAncestors(parentMap, parent));
    }

    return result;
  }

  private static void printList(List<Integer> list) {
    for (Integer element : list) {
      System.out.print(element + " ");
    }
    System.out.println();
  }
}
