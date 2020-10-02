package com.nalmoussa.coding.practice.problem024;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BinarySearchTree {
    private BinaryNode root;

    void print(TraversalOrder traversalOrder, BinaryNodeConsumer printer, boolean traverseIteratively) {
        if (traverseIteratively) {
            printIteratively(traversalOrder, printer);
        }
        else {
            printRecursively(traversalOrder, printer);
        }
    }

    private void printIteratively(TraversalOrder traversalOrder, BinaryNodeConsumer printer) {
        switch (traversalOrder) {
            case IN_ORDER:
                traverseInOrderIteratively(root, printer);
                break;
            case LEVEL:
                traverseLevelOrderIteratively(root, printer);
                break;
            case POST_ORDER:
                traversePostOrderIteratively(root, printer);
                break;
            case PRE_ORDER:
                traversePreOrderIteratively(root, printer);
                break;
        }
    }

    private void printRecursively(TraversalOrder traversalOrder, BinaryNodeConsumer printer) {
        switch (traversalOrder) {
            case IN_ORDER:
                traverseInOrderRecursively(root, printer);
                break;
            case LEVEL:
                traverseLevelOrderRecursively(root, printer, 0, 0);
                break;
            case POST_ORDER:
                traversePostOrderRecursively(root, printer);
                break;
            case PRE_ORDER:
                traversePreOrderRecursively(root, printer);
                break;
        }
    }

    private void traverseInOrderIteratively(BinaryNode node, BinaryNodeConsumer nodeConsumer) {
        if (node != null) {
            Stack<BinaryNode> stack = new Stack<>();
            stack.add(node);
            BinaryNode currentNode = node;
            while (!stack.isEmpty()) {
                node = stack.peek();
                if ((node.left != null) && (node == currentNode)) {
                    stack.add(node.left);
                    currentNode = node.left;
                }
                else {
                    node = stack.pop();
                    nodeConsumer.accept(node);
                    currentNode = node;
                    if (node.right != null) {
                        stack.add(node.right);
                        currentNode = node.right;
                    }
                }
            }
        }
    }

    private void traverseLevelOrderIteratively(BinaryNode node, BinaryNodeConsumer nodeConsumer) {
        if (node != null) {
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(node);
            BinaryNode nextNode;
            while (!queue.isEmpty()) {
                nextNode = queue.remove();
                nodeConsumer.accept(nextNode);
                if (nextNode.left != null) {
                    queue.add(nextNode.left);
                }
                if (nextNode.right != null) {
                    queue.add(nextNode.right);
                }
            }
        }
    }

    private void traversePostOrderIteratively(BinaryNode node, BinaryNodeConsumer nodeConsumer) {
        if (node != null) {
            Stack<BinaryNode> stack = new Stack<>();
            stack.add(node);
            BinaryNode currentNode = node;
            while (!stack.isEmpty()) {
                node = stack.peek();
                if ((node.left != null) && (node == currentNode)) {
                    stack.add(node.left);
                    currentNode = node.left;
                }
                else {
                    if ((node.right != null) && (node.right != currentNode)) {
                        stack.add(node.right);
                        currentNode = node.right;
                    }
                    else {
                        node = stack.pop();
                        nodeConsumer.accept(node);
                        currentNode = node;
                    }
                }
            }
        }
    }

    private void traversePreOrderIteratively(BinaryNode node, BinaryNodeConsumer nodeConsumer) {
        if (node != null) {
            Stack<BinaryNode> stack = new Stack<>();
            stack.add(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                nodeConsumer.accept(node);
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
        }
    }

    private void traverseInOrderRecursively(BinaryNode node, BinaryNodeConsumer nodeConsumer) {
        if (node != null) {
            traverseInOrderRecursively(node.left, nodeConsumer);
            nodeConsumer.accept(node);
            traverseInOrderRecursively(node.right, nodeConsumer);
        }
    }

    private boolean traverseLevelOrderRecursively(BinaryNode node, BinaryNodeConsumer nodeConsumer, int level, int desiredLevel) {
        boolean hasPrinted = false;
        if ((node != null) && (level <= desiredLevel)) {
            if (level == desiredLevel) {
                nodeConsumer.accept(node);
                hasPrinted = true;
            }
            else {
                int nextLevel = level + 1;
                boolean hasPrintedLeft = traverseLevelOrderRecursively(node.left, nodeConsumer, nextLevel, desiredLevel);
                boolean hasPrintedRight = traverseLevelOrderRecursively(node.right, nodeConsumer, nextLevel, desiredLevel);
                hasPrinted = hasPrintedLeft || hasPrintedRight;
            }
        }
        if ((level == 0) && (hasPrinted)) {
            int nextDesiredLevel = desiredLevel + 1;
            traverseLevelOrderRecursively(node, nodeConsumer, level, nextDesiredLevel);
        }
        return hasPrinted;
    }

    private void traversePostOrderRecursively(BinaryNode node, BinaryNodeConsumer nodeConsumer) {
        if (node != null) {
            traversePostOrderRecursively(node.left, nodeConsumer);
            traversePostOrderRecursively(node.right, nodeConsumer);
            nodeConsumer.accept(node);
        }
    }

    private void traversePreOrderRecursively(BinaryNode node, BinaryNodeConsumer nodeConsumer) {
        if (node != null) {
            nodeConsumer.accept(node);
            traversePreOrderRecursively(node.left, nodeConsumer);
            traversePreOrderRecursively(node.right, nodeConsumer);
        }
    }

    void insert(int[] values) {
        if (values != null) {
            for (int value : values) {
                insert(value);
            }
        }
    }

    void insert(int value) {
        if (root == null) {
            root = new BinaryNode(value);
        }
        else {
            insert(root, value);
        }
    }

    private void insert(BinaryNode node, int value) {
        if (node.value != value) {
            if (value < node.value) {
                if (node.left == null) {
                    node.left = new BinaryNode(value);
                }
                else {
                    insert(node.left, value);
                }
            }
            else {
                if (node.right == null) {
                    node.right = new BinaryNode(value);
                }
                else {
                    insert(node.right, value);
                }
            }
        }
    }

    int height() {
        return height(root);
    }

    private int height(BinaryNode node) {
        int nodeHeight = 0;
        if (!(node == null || node.isLeaf())) {
            nodeHeight = Math.max(height(node.left), height(node.right)) + 1;
        }
        return nodeHeight;
    }

    int depth() {
        return depth(root);
    }

    private int depth(BinaryNode node) {
        return findDepthAndDiameter(node).depth;
    }

    int diameter() {
        return findDepthAndDiameter(root).diameter;
    }

    private DepthAndDiameterData findDepthAndDiameter(BinaryNode node) {
        int depth = 0;
        int diameter = 0;

        if ((node != null) && !(node.isLeaf())) {
            int leftEdge = (node.left == null) ? 0 : 1;
            int rightEdge = (node.right == null) ? 0 : 1;

            DepthAndDiameterData left = findDepthAndDiameter(node.left);
            DepthAndDiameterData right = findDepthAndDiameter(node.right);

            depth = Math.max(left.depth, right.depth) + 1;
            diameter = left.depth + leftEdge + right.depth + rightEdge;
            diameter = Math.max(diameter, Math.max(left.diameter, right.diameter));
        }

        return new DepthAndDiameterData(depth, diameter);
    }

    static int countUniqueTrees(int n) {
        n = (n < 0) ? -1 : n;
        int count = (n > 0) ? 0 : n + 1;

        if (n > 0) {
            for (int root = 1; root <= n; root++) {
                count += countUniqueTrees(root - 1) * countUniqueTrees(n - root);
            }
        }

        return count;
    }

    static int countUniqueTreesFast(int n) {
        n = (n < 0) ? -1 : n;
        int count = (n > 0) ? 0 : n + 1;

        if (n > 0) {
            UniqueBinaryTreesCountMap countMap = new UniqueBinaryTreesCountMap(n);
            for (int i = 0; i < n; i++) {
                count += countMap.get(i) * countMap.get(n - i -1);
            }
        }

        return count;
    }
}
