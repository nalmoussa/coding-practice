package com.nalmoussa.coding.practice.problem024;

class BinaryNodePrinter implements BinaryNodeConsumer {
    @Override
    public void accept(BinaryNode node) {
        System.out.println(node.value);
    }
}
