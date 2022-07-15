package com.nalmoussa.coding.practice.problem053;

public class Solution {
  private int longestPossiblePalindrome(int beginIndex, int endIndex, int strLength) {
    int rightWing = (strLength-1) - endIndex;
    int wing = Math.min(beginIndex, rightWing);
    return (endIndex - beginIndex + 1) + 2 * wing;
  }

  private String findPalindromeAt(int beginIndex, int endIndex, String s) {
    while ((beginIndex > 0) && (endIndex < s.length() - 1) && (s.charAt(beginIndex-1) == s.charAt(endIndex+1))) {
      beginIndex--;
      endIndex++;
    }
    return s.substring(beginIndex, endIndex + 1);
  }

  private boolean isPalindromeHead(int beginIndex, int endIndex, String s) {
    return (beginIndex >= 0) &&
        (endIndex < s.length()) &&
        (beginIndex <= endIndex) &&
        (endIndex - beginIndex < 3) &&
        (s.charAt(beginIndex) == s.charAt(endIndex));
  }

  private String maxPalindrome(int beginIndex, int endIndex, String s, String longestP) {
    if (isPalindromeHead(beginIndex, endIndex, s) &&
        (longestPossiblePalindrome(beginIndex, endIndex, s.length()) > longestP.length())) {
      String palindrome = findPalindromeAt(beginIndex, endIndex, s);
      if (palindrome.length() > longestP.length()) {
        longestP = palindrome;
      }
    }
    return longestP;
  }

  private String maxPalindrome(int index, String s, String longestP) {
    longestP = maxPalindrome(index, index + 1, s, longestP);
    longestP = maxPalindrome(index - 1, index + 1, s, longestP);
    return longestP;
  }

  public String longestPalindrome(String s) {
    if (s == null || s.isEmpty()) {
      return "";
    }

    String longestP = s.substring(0, 1);
    int midPoint = s.length() / 2;
    for (int index = 0; index < midPoint; index++) {
      int rightIndex = midPoint + index;
      int leftIndex = midPoint - index - 1;
      longestP = maxPalindrome(rightIndex, s, longestP);
      longestP = maxPalindrome(leftIndex, s, longestP);
    }

    return longestP;
  }
}
