package com.nalmoussa;

import org.junit.Test;

public class SpiralArrayTests {
    @Test
    public void verifySpiralWorksAsExpected() {
        int n = 7;
        print(SpiralArray.spiral(n), n);
    }

    private void print(int[][] result, int n) {
        //Assuming it is valid array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
