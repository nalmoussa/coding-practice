package com.nalmoussa.coding.practice;

public class DoubleLinkedList {
    private DoubleLinkedNode head = null;
    private DoubleLinkedNode last = null;

    public void add(Integer value) {
        if (head == null) {
            head = new DoubleLinkedNode(value);
            last = head;
        }
        else {
            last.next = new DoubleLinkedNode(value);
            last.next.prev = last;
            last = last.next;
        }
    }

    public void add(Integer[] array) {
        for (Integer value : array) {
            add(value);
        }
    }

    public void print() {
        DoubleLinkedNode current = head;
        System.out.print("{");
        while (current != null) {
            System.out.print(current.value);
            current = current.next;
            if (current != null) {
                System.out.print(" ");
            }
        }
        System.out.print("} ");
        printHeadAndLast();
    }

    private void printHeadAndLast() {
        String headValue = (head == null) ? "null" : head.value.toString();
        String lastValue = (last == null) ? "null" : last.value.toString();
        System.out.println("head = " + headValue + "; last = " + lastValue);
    }

    public DoubleLinkedNode getHead() {
        return head;
    }

    public void remove(DoubleLinkedNode node) {
        if (head != null) {
            if (node == head) {
                head = head.next;
            }
            if (node == last) {
                last = last.prev;
            }
            DoubleLinkedNode prev = node.prev;
            DoubleLinkedNode next = node.next;
            if (prev != null) { prev.next = next; }
            if (next != null) { next.prev = prev; }
        }
    }
}
