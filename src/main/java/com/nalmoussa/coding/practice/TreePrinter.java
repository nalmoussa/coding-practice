package com.nalmoussa.coding.practice;

class TreePrinter implements NodeConsumer {
    private int currentLevel;

    @Override
    public void start() {
        currentLevel = 0;
    }

    @Override
    public void accept(NodeData nodeData) {
        if (belongsToNextLevel(nodeData)) {
            currentLevel++;
            System.out.println();
        }
        System.out.print(nodeData.node.getValue() + " ");
    }

    @Override
    public void end() {
        System.out.println();
    }

    @Override
    public boolean belongsToNextLevel(NodeData nodeData) {
        return (nodeData.level == currentLevel + 1);
    }
}
