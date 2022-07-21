package com.nalmoussa.coding.practice.problem055;

public class Solution {
  // get the sign first and make the number absolute
  // loop while we haven't reached the end and the number is still in the int range
  // apply the sign
  public int reverse(int x) {
    if (x == 0 || x == Integer.MIN_VALUE) {
      return 0;
    }

    int sign = x / Math.abs(x);
    x = sign * x;
    int answer = 0;

    while (x > 0) {
      int d = x % 10;
      x = x / 10;
      if (answer <= (Integer.MAX_VALUE / 10)) {
        answer *= 10;
      } else {
        return 0;
      }

      if (answer <= (Integer.MAX_VALUE - d)) {
        answer += d;
      } else {
        return 0;
      }
    }

    return  sign * answer;
  }
}
