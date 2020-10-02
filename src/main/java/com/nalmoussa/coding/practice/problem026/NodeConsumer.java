package com.nalmoussa.coding.practice.problem026;

import java.util.function.Consumer;

interface NodeConsumer extends Consumer<NodeData> {
    void start();
    void end();
    boolean belongsToNextLevel(NodeData nodeData);
}
