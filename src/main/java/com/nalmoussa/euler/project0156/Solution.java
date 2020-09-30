package com.nalmoussa.euler.project0156;

import java.time.Duration;
import java.time.LocalDateTime;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    LocalDateTime t1 = LocalDateTime.now();
    long[] s = solution.s();
    LocalDateTime t2 = LocalDateTime.now();
    long duration = Duration.between(t1, t2).toMillis();

    long sum = 0;
    System.out.println();
    for (int d = 1; d < 10; d++) {
      System.out.println("s(" + d + ") = " + s[d - 1]);
      sum += s[d - 1];
    }
    System.out.println("Answer: " + sum);
    System.out.println("Duration: " + duration);
  }

  private long[] s() {
    long[] f   = new long[9];
    long[] sum = new long[9];

    for (int d = 1; d < 10; d++) {
      f[d - 1] = 0;
      sum[d - 1] = 0;
    }

    long N = Integer.MAX_VALUE;
    for (long n = 1; n < N; n++) {
      long ratio = Math.round(100 * ((double) n / N));
      printProgress(n, ratio);
      int[] t = t(n);
      for (int d = 1; d < 10; d++) {
        f[d - 1] += t[d - 1];
        if (f[d - 1] == n) {
          sum[d - 1] += n;
        }
      }
    }

    return sum;
  }

//  private int[] t(long n) {
//    int[] sum = new int[9];
//    for (int d = 1; d < 10; d++) {
//      sum[d - 1] = 0;
//    }
//
//    while (n > 0) {
//      long d = n % 10;
//      n = n / 10;
//      if (d > 0) {
//        sum[(int)(d - 1)]++;
//      }
//    }
//    return sum;
//  }

  private int[] t(long n) {
    return new int[9];
  }

  private void printProgress(long n, long ratio) {
    if (n % 1000000 == 0) {
      System.out.print('.');
      if (n % 100000000 == 0) {
        String ratioStr = " " + ratio + "%";
        System.out.println(ratioStr);
      }
    }
  }
}
