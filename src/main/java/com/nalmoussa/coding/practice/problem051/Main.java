package com.nalmoussa.coding.practice.problem051;

public class Main {
  public static void main(String[] args) {
    int[] a1 = {9, 9, 9, 9, 9, 9, 9};
    int[] a2 = {9, 9, 9, 9};
    Solution s = new Solution();

    ListNode l1 = convertArrayToListNode(a1);
    ListNode l2 = convertArrayToListNode(a2);
    ListNode l = s.addTwoNumbers(l1, l2);

    printListNode(l1, "l1");
    printListNode(l2, "l2");
    printListNode(l, "l");
  }

  private static ListNode convertArrayToListNode(int[] array) {
    ListNode header = new ListNode(array[0]);
    ListNode curr = header;
    for (int index = 1; index < array.length; index++) {
      curr.next = new ListNode(array[index]);
      curr = curr.next;
    }
    return header;
  }

  private static void printListNode(ListNode l, String name) {
    String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    ListNode curr = l;
    String csn = digits[l.val];
    while (curr.next != null) {
      curr = curr.next;
      csn = csn + "," + digits[curr.val];
    }
    System.out.println(name + " = [" + csn + "]");
  }
}
