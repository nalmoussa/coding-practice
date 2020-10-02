package com.nalmoussa.coding.practice;

class TwoConsecutives extends IntegerArrayBase {
    TwoConsecutives(Integer[] inputArray) {
        super(inputArray);
    }

    Integer[] solve() {
        Integer[] result = inputArray.clone();
        int[] nextIndex = createNextIndexArray(inputArray.length);

        boolean hasMatch = true;
        while (hasMatch) {
            hasMatch = false;
            int index = 0;
            while (nextIndex[index] != -1) {
                Integer item = result[index];
                Integer nextItem = result[nextIndex[index]];
                if (item.equals(nextItem)) {
                    result[index]++;
                    result[nextIndex[index]] = null;
                    nextIndex[index] = nextIndex[nextIndex[index]];
                    hasMatch = true;
                    break;
                }
                index = nextIndex[index];
            }
        }
        return result;
    }

    void solveUsingDoubleLinkedList() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(inputArray);
        boolean hasMatch = true;
        while (hasMatch) {
            hasMatch = false;
            DoubleLinkedNode current = doubleLinkedList.getHead();
            DoubleLinkedNode next = current.next;
            while (next != null) {
                if (current.value.equals(next.value)) {
                    current.value++;
                    doubleLinkedList.remove(next);
                    hasMatch = true;
                    break;
                }
                current = next;
                next = current.next;
            }
        }
    }

    void solveUsingDoubleLinkedListFast() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(inputArray);
        DoubleLinkedNode current = doubleLinkedList.getHead();
        while (current.next != null) {
            if (current.value.equals(current.next.value)) {
                current.value++;
                doubleLinkedList.remove(current.next);
                if (current.prev != null) {
                    current = current.prev;
                }
            }
            else {
                current = current.next;
            }
        }
    }

    private int[] createNextIndexArray(int n) {
        int[] nextIndex = new int[n];
        for (int i = 0; i < n - 1; i++) {
            nextIndex[i] = i + 1;
        }
        nextIndex[n - 1] = -1;
        return nextIndex;
    }
}
