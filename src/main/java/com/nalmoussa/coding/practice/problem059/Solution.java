package com.nalmoussa.coding.practice.problem059;

public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    n = 100 * n + 1;
    ListNode node = head;
    while (node.next != null) {
      n++;
      node = node.next;
    }
    n = (n % 100) - (n / 100);
    if (n == 0) {
      return head.next;
    }

    node = head;
    while (--n > 0) {
      node = node.next;
    }
    node.next = node.next.next;
    return head;
  }
}
