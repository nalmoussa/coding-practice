package com.nalmoussa.coding.practice.problem007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class WaterFill {
    private HashMap<Integer, Boolean> visited;
    private List<Integer> zeroIndex;
    private List<Integer> lakeSize;

    WaterFill(int[][] input, int n) {
        init(input, n);
        computeAllLakeSizes(n);
        Collections.sort(lakeSize);
    }

    List<Integer> getLakeSize() {
        return lakeSize;
    }

    private void init(int[][] input, int n) {
        visited = new HashMap<>();
        zeroIndex = new ArrayList<>();
        lakeSize = new ArrayList<>();

        int index;
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (input[row][column] == 0) {
                    index = getIndex(row, column, n);
                    visited.put(index, false);
                    zeroIndex.add(index);
                }
            }
        }
    }

    private void computeAllLakeSizes(int n) {
        for (Integer index : zeroIndex) {
            if (!visited.get(index)) {
                lakeSize.add(computeLakeSize(index, n));
            }
        }
    }

    private int computeLakeSize(Integer center, int n) {
        visited.put(center, true);
        int size = 1;
        for (Integer index : zeroIndex) {
            if ((!visited.get(index)) && (!center.equals(index)) && (areNeighbors(center, index, n))) {
                size += computeLakeSize(index, n);
            }
        }
        return size;
    }

    private static int getIndex(int row, int column, int n) {
        return n * row + column;
    }

    private static int getRow(int index, int n) {
        return index / n;
    }

    private static int getColumn(int index, int n) {
        return index % n;
    }

    private static boolean areNeighbors(int index1, int index2, int n) {
        int i1 = getRow(index1, n);
        int i2 = getRow(index2, n);
        int j1 = getColumn(index1, n);
        int j2 = getColumn(index2, n);

        int rowDiff = Math.abs(i2-i1);
        int columnDiff = Math.abs(j2-j1);
        return ((rowDiff < 2) && (columnDiff < 2));
    }
}
