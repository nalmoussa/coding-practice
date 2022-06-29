package com.nalmoussa.coding.practice.problem051;

public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwoNumbers(l1, l2, 0);
  }

  private ListNode addTwoNumbers(ListNode l1, ListNode l2, int remainder) {
    if (l1 == null && l2 == null) {
      return (remainder == 0) ? null : new ListNode(1);
    }

    int num1 = (l1 == null) ? 0 : l1.val;
    int num2 = (l2 == null) ? 0 : l2.val;
    int sum = (num1 + num2 + remainder);
    int num = sum % 10;
    remainder = sum / 10;

    l1 = (l1 == null) ? null : l1.next;
    l2 = (l2 == null) ? null : l2.next;
    return new ListNode(num, addTwoNumbers(l1, l2, remainder));
  }
}
