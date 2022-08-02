package com.nalmoussa.coding.practice.problem059;

public class ListNode {
   int val;
   ListNode next;
   ListNode() {}

   ListNode(int val) {
     this.val = val;
   }

   ListNode(int val, ListNode next) {
     this.val = val;
     this.next = next;
   }

  public ListNode(int[] values) {
     ListNode current = null;
    for (int i = 0; i < values.length; i++) {
      if (current == null) {
        this.val  = values[i];
        current = this;
      } else {
        current.next = new ListNode(values[i]);
        current = current.next;
      }
    }
  }

  void print() {
     System.out.print(this.val + " ");
     if (this.next == null) {
       System.out.println();
     } else {
       this.next.print();
     }
   }
}
