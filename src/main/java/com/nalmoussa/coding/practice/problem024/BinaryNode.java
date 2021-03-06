package com.nalmoussa.coding.practice.problem024;

class BinaryNode {
    int value;
    BinaryNode left;
    BinaryNode right;

    BinaryNode(int value) {
        this.value = value;
    }

    boolean isLeaf() {
        return ((left == null) && (right == null));
    }
}
