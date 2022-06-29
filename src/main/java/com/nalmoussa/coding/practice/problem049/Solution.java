package com.nalmoussa.coding.practice.problem049;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  public static void main(String[] args) {
    int[] satisfaction = {-1,-8,0,5,-9};
    System.out.println(maxSatisfaction(satisfaction));
  }

  private static int maxSatisfaction(int[] satisfaction) {
    Queue<Integer> nonNegativeReviews = new PriorityQueue<>();
    Queue<Integer> negativeReviews = new PriorityQueue<>();

    int nonNegativeReviewSum = 0;
    for (int review : satisfaction) {
      if (review < 0) {
        negativeReviews.add(-1 * review);
      } else {
        nonNegativeReviews.add(review);
        nonNegativeReviewSum += review;
      }
    }

    int counter = 1;
    int total = 0;
    int negativeReviewSumSoFar = 0;
    while (!negativeReviews.isEmpty()) {
      int review = negativeReviews.poll();
      int reviewImpact = negativeReviewSumSoFar + review;
      if (reviewImpact <= nonNegativeReviewSum) {
        counter++;
        total -= reviewImpact;
        negativeReviewSumSoFar += review;
      } else {
        break;
      }
    }

    while (!nonNegativeReviews.isEmpty()) {
      int review = nonNegativeReviews.poll();
      int reviewImpact = review * counter;
      total += reviewImpact;
      counter++;
    }
    return total;
  }
}
