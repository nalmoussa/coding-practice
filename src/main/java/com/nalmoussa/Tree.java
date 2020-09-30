package com.nalmoussa;

import java.util.*;

public class Tree {
    private Node root;

    private Tree(Node root) {
        this.root = root;
    }

    private Node getRoot() {
        return root;
    }

    public static Tree generateRandomTree(Random rand, int height) {
        Tree tree = null;

        if (height >= 0) {
            Node root = Node.generateRandomLeafNode(rand);
            tree = new Tree(root);
            if (height > 0) {
                int numberOfChildren = rand.nextInt(4) + 1;
                int randomChild = rand.nextInt(numberOfChildren);
                int childHeight;
                for (int i = 0; i < numberOfChildren; i++) {
                    childHeight = (i == randomChild) ? height -1 : rand.nextInt(height);
                    root.addChild(Tree.generateRandomTree(rand, childHeight).getRoot());
                }
            }
        }

        return tree;
    }

    public void print() {
        breadthFirstSearch(new TreePrinter());
    }

    public void findWidestLevelUsingBFS() {
        TreeWidthFinder widthFinder = new TreeWidthFinder();
        breadthFirstSearch(widthFinder);

        System.out.println("The Widest Level = " + widthFinder.max.level);
        System.out.println("The width is = " + widthFinder.max.width);
    }

    public void findWidestLevel() {
        int widestLevel = 0;
        int widestWidth = 0;

        if (this.root != null) {
            if (this.root.isLeaf()) {
                widestWidth = 1;
            }
            else {
                HashMap<Integer, Integer> counter = new HashMap<>();
                counter.put(0, 1);
                computeChildrenCountPerLevel(root, 0, counter);
                for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                    if (entry.getValue() > widestWidth) {
                        widestLevel = entry.getKey();
                        widestWidth = entry.getValue();
                    }
                }
            }
        }

        System.out.println("The Widest Level = " + widestLevel);
        System.out.println("The width is = " + widestWidth);
    }

    private void computeChildrenCountPerLevel(Node node, int nodeLevel, HashMap<Integer, Integer> counter) {
        if (node == null || node.isLeaf()) {
            return;
        }

        int childrenLevel = nodeLevel + 1;
        int oldCount = counter.getOrDefault(childrenLevel, 0);
        int newCount = oldCount + node.childrenCount();
        counter.put(childrenLevel, newCount);
        for (Node child : node.getChildren()) {
            computeChildrenCountPerLevel(child, childrenLevel, counter);
        }
    }

    private void breadthFirstSearch(NodeConsumer nodeConsumer) {
        if (root == null) {
            System.out.println("The tree root is null");
        }
        else {
            NodeData currentDataBag;
            Queue<NodeData> queue = new LinkedList<>();
            queue.add(new NodeData(root, 0));

            nodeConsumer.start();
            while (!queue.isEmpty()) {
                currentDataBag  = queue.remove();
                nodeConsumer.accept(currentDataBag);

                if (!currentDataBag.node.isLeaf()) {
                    for (Node child : currentDataBag.node.getChildren()) {
                        queue.add(new NodeData(child, currentDataBag.level + 1));
                    }
                }
            }
            nodeConsumer.end();
        }
    }
}
