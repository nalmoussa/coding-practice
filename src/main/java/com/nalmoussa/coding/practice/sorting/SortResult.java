package com.nalmoussa.coding.practice.sorting;

class SortResult {
    final int comparisonCount;
    final int swapCount;
    final Integer[] sortedArray;

    SortResult(int comparisonCount, int swapCount, Integer[] sortedArray) {
        this.comparisonCount = comparisonCount;
        this.sortedArray = sortedArray;
        this.swapCount = swapCount;
    }
}
