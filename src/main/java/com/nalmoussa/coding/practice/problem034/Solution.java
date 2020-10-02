package com.nalmoussa.coding.practice.problem034;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    firstQuestion();
    secondQuestion();
  }

  public static void firstQuestion() {
    String[] array1 = {"a", "b", "c", "d", "e", "f", "g"};
    printArray(array1);
    reverse(array1, 2, 5);
    printArray(array1);

    String[] array2 = {"T", "o", "d", "a", "y", " ", "i", "s", " ", "a", " ", "n", "i", "c", "e", " ", "d", "a", "y", " ", "i", "n", " ", "S", "e", "a", "t", "t", "l", "e"};
    printArray(array2);
    reverseWords(array2);
    printArray(array2);
  }

  private static void reverse(String[] array, int startIndex, int endIndex) {
    int leftIndex = startIndex;
    int rightIndex = endIndex;
    while (leftIndex < rightIndex) {
      swap(array, leftIndex, rightIndex);
      leftIndex++;
      rightIndex--;
    }
  }

  private static void reverseWords(String[] array) {
    int startIndex = 0;
    while (startIndex < array.length) {
      int endIndex = getWordEndIndex(array, startIndex);
      reverse(array, startIndex, endIndex);
      startIndex = endIndex + 2;
    }
    reverse(array, 0, array.length - 1);
  }

  private static int getWordEndIndex(String[] array, int startIndex) {
    int endIndex = startIndex + 1;
    while (endIndex < array.length && !array[endIndex].equals(" ")) {
      endIndex++;
    }

    return endIndex - 1;
  }

  private static void swap(String[] array, int index1, int index2) {
    String temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }

  public static void secondQuestion() {
    String word1 = "JAVA";
    String word2 = "POLO";
    String result = (areFriendly(word1, word2)) ? "friendly" : "unfriendly";
    System.out.println(word1 + " and " + word2 + " are " + result + " words");

    String[] words = {"LESS", "POLE", "SITTING", "PALE", "RUNNING", "WALL", "JAVA", "ROLL", "POLO"};
    String[] groupedWords = groupFriendlyWords(words);
    printArray(words);
    printArray(groupedWords);
  }

  public static boolean areFriendly(String word1, String word2) {
    int hash1 = createWordHashCode(word1);
    int hash2 = createWordHashCode(word2);
    return (hash1 == hash2);
  }

  public static String[] groupFriendlyWords(String[] words) {
    Map<Integer, List<String>> wordMap = new HashMap<>();
    for (String word : words) {
      int hash = createWordHashCode(word);
      List<String> wordList = wordMap.getOrDefault(hash, new ArrayList<>());
      wordList.add(word);
      wordMap.put(hash, wordList);
    }

    String[] result = new String[words.length];
    int index = 0;
    for (Integer hash : wordMap.keySet()) {
      List<String> wordList = wordMap.get(hash);
      for (String word : wordList) {
        result[index++] = word;
      }
    }

    return result;
  }

  private static int createWordHashCode(String word) {
    int length = word.length();
    int nextValue = 0;
    int[] signature = new int[length];
    Map<String, Integer> signatureMap = new HashMap<>();
    for (int i = 0; i < word.length(); i++) {
      String ch = word.substring(i, i + 1);
      Integer value = signatureMap.get(ch);
      if (value == null) {
        value = nextValue++;
        signatureMap.put(ch, value);
      }
      signature[i] = value;
    }
    return Arrays.hashCode(signature);
  }

  private static void printArray(String[] words) {
    for (String word : words) {
      System.out.print(word);
    }
    System.out.println();
  }
}
