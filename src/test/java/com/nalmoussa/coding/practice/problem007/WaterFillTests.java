package com.nalmoussa.coding.practice.problem007;

import org.junit.Assert;
import org.junit.Test;

public class WaterFillTests {
    @Test
    public void verifySomething() {
        int n = 4;
        int[] data = {0,2,1,0,0,1,0,1,1,1,0,1,0,1,0,1};
        int[][] input = generateInputArray(data, n);
        print(input, n);
        WaterFill waterFill = new WaterFill(input, n);


        for (Integer size : waterFill.getLakeSize()) {
            System.out.println(size);
        }

        Assert.assertTrue("Message", (waterFill.getLakeSize().size() > 0));
    }

    private int[][] generateInputArray(int[] data, int n) {
        int[][] input = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(data, i * n, input[i], 0, n);
        }

        return input;
    }

    private void print(int[][] input, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
