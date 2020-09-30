package com.nalmoussa;

class BinaryNodePrinter implements BinaryNodeConsumer {
    @Override
    public void accept(BinaryNode node) {
        System.out.println(node.value);
    }
}
