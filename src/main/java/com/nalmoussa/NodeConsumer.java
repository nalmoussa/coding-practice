package com.nalmoussa;

import java.util.function.Consumer;

interface NodeConsumer extends Consumer<NodeData> {
    void start();
    void end();
    boolean belongsToNextLevel(NodeData nodeData);
}
