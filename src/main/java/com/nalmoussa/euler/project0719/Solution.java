package com.nalmoussa.euler.project0719;

import java.time.Duration;
import java.time.LocalDateTime;

public class Solution {
  public static void main(String[] args) {
    int p = 12; //For p = 12, the answer is 128088830547982
    Solution solution = new Solution(p);

    System.out.println();
    System.out.println("T(10^" + p + ") is: " + solution.getT());
    System.out.println("Duration: " + solution.getDuration() + " millis");
  }

  private final long t;
  private final long duration;

  private Solution(int p) {
    long N = (long)Math.pow(10, p);
    LocalDateTime t1 = LocalDateTime.now();
    this.t = FindT(N);
    LocalDateTime t2 = LocalDateTime.now();
    this.duration = Duration.between(t1, t2).toMillis();
  }

  private long getT() {
    return this.t;
  }

  private long getDuration() {
    return this.duration;
  }

  private long FindT(long N) {
    long sqrtN = (long)Math.sqrt(N);
    long sum = 0;
    // We deliberately avoid 1 because sqrt(1) is 1
    // But 1 can't be represented as 2 or more numbers
    for (long sqrt = 2; sqrt <= sqrtN; sqrt++) {
      printProgress(sqrt);
      long sqr = sqrt * sqrt;
      if (isSplitNumber(sqrt, sqr)) {
        sum += sqr;
      }
    }
    return sum;
  }

  private boolean isSplitNumber(long rep, long number) {
    boolean answer = false;
    if (rep == number) {
      answer = true;
    } else {
      long d = 10;
      while (d <= number) {
        long remaining = rep - number % d;
        if ((remaining >= 0) && isSplitNumber(remaining, number / d)) {
          answer = true;
          break;
        }
        d *= 10;
      }
    }

    return answer;
  }

  private void printProgress(long sqrt) {
    if (sqrt % 1000 == 0) {
      System.out.print('.');
      if (sqrt % 100000 == 0) {
        System.out.println();
      }
    }
  }
}
