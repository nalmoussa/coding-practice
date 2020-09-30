package com.nalmoussa;

class SpiralArray {
    static int[][] spiral(int n) {
        // Validate that n is valid integer
        // 1) Is there a max value for n
        // 2) n can not be negative

        int[][] result = new int[n][n];
        int row = 0;
        int column = 0;
        int rowStep = 0; // this can be: -1, 0, 1
        int columnStep = 1; // this can be: -1, 0, 1
        int[] stepValues = {0, 1, 0, -1};
        int stepValuesSize = 4;
        int rowStepValueIndex = 0;
        int columnStepValueIndex = 1;
        int nextRow, nextColumn;
        for (int value = 1; value <= n*n; value++) {
            result[row][column] = value;
            nextRow = row + rowStep;
            nextColumn = column + columnStep;
            if (invalidIndex(nextRow, nextColumn, n) || (result[nextRow][nextColumn] != 0)) {
                // update rowStep and columnStep
                rowStepValueIndex = (rowStepValueIndex + 1) % stepValuesSize;
                columnStepValueIndex = (columnStepValueIndex + 1) % stepValuesSize;
                rowStep = stepValues[rowStepValueIndex];
                columnStep = stepValues[columnStepValueIndex];
                nextRow = row + rowStep;
                nextColumn = column + columnStep;
            }
            row = nextRow;
            column = nextColumn;
        }

        return result;
    }

    private static boolean invalidIndex(int row, int column, int n) {
        return (row >= n) || (column >= n) || (row < 0) || (column < 0);
    }
}


// 1) Test for invalid n
// 2) Test for n = 1
// 3) Test for n = max value
// 4) Test for n = some valid value in the middle like 6
