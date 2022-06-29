package com.nalmoussa.coding.practice.problem052;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> indexMap = new HashMap<>();
    int start_index = 0;
    int maxLength = 0;
    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      if (indexMap.containsKey(c)) {
        int prev_index = indexMap.get(c);
        indexMap.put(c, i);
        if (prev_index >= start_index) {
          maxLength = Math.max(maxLength, i - start_index);
          start_index = prev_index + 1;
        }
      } else {
        indexMap.put(c, i);
      }
    }
    maxLength = Math.max(maxLength, s.length() - start_index);
    return maxLength;
  }
}
