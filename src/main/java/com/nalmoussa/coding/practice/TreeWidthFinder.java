package com.nalmoussa.coding.practice;

class TreeWidthFinder implements NodeConsumer {
    private WidthData current;
    WidthData max;

    @Override
    public void start() {
        current = new WidthData(0, 0);
        max = new WidthData(0, 0);
    }

    @Override
    public void accept(NodeData nodeData) {
        if (belongsToNextLevel(nodeData)) {
            updateMax();
            current.width = 0;
            current.level++;
        }
        current.width++;
    }

    @Override
    public void end() {
        updateMax();
    }

    @Override
    public boolean belongsToNextLevel(NodeData nodeData) {
        return (nodeData.level == current.level + 1);
    }

    private void updateMax() {
        if (current.width > max.width) {
            max = new WidthData(current.width, current.level);
        }
    }
}
