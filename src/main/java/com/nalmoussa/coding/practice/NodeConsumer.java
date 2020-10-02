package com.nalmoussa.coding.practice;

import java.util.function.Consumer;

interface NodeConsumer extends Consumer<NodeData> {
    void start();
    void end();
    boolean belongsToNextLevel(NodeData nodeData);
}
