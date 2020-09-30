package com.nalmoussa;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Node {
    private final int value;
    private List<Node> children = null;

    private Node(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    void addChild(Node node) {
        if (this.children == null) {
            this.children = new LinkedList<>();
        }
        this.children.add(node);
    }

    boolean isLeaf() {
        return (this.childrenCount() == 0);
    }

    int childrenCount() {
        return (this.children == null) ? 0 : this.children.size();
    }

    List<Node> getChildren() {
        return children;
    }

    static Node generateRandomLeafNode(Random rand) {
        return new Node(rand.nextInt(5) + 1);
    }
}
