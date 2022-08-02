package com.nalmoussa.coding.practice.problem059;

public class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] values = {1,2,3,4,5};
    ListNode head = new ListNode(values);
    head.print();
    ListNode answer = solution.removeNthFromEnd(head, 1);
    if (answer == null) {
      System.out.println("[]");
    } else {
      answer.print();
    }
  }
}
