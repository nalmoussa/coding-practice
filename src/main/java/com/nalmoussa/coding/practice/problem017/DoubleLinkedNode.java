package com.nalmoussa.coding.practice.problem017;

public class DoubleLinkedNode {
    public Integer value;
    public DoubleLinkedNode prev;
    public DoubleLinkedNode next;

    DoubleLinkedNode(Integer value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
