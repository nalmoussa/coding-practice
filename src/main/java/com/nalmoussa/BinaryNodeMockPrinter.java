package com.nalmoussa;

import java.util.LinkedList;
import java.util.List;

class BinaryNodeMockPrinter implements BinaryNodeConsumer {
    private List<Integer> values = new LinkedList<>();

    @Override
    public void accept(BinaryNode node) {
        values.add(node.value);
    }

    int[] getPrintedValues() {
        int[] printedValues = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            printedValues[i] = values.get(i);
        }
        return printedValues;
    }
}
