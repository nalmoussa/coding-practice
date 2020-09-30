package com.nalmoussa;

public class MultiplesOf3And5 {
    public static int sumMultiplesOf3And5Slow(int bound) {
        int multiplesOf3 = 3;
        int multiplesOf5 = 5;
        int sum3 = 0;
        int sum5 = 0;
        while ((multiplesOf3 < bound) || (multiplesOf5 < bound)) {
            if (multiplesOf3 % 5 != 0) {
                sum3 += multiplesOf3;
            }

            if (multiplesOf5 < bound) {
                sum5 += multiplesOf5;
            }

            multiplesOf3 += 3;
            multiplesOf5 += 5;
        }
        return (sum3 + sum5);
    }

    public static int sumMultiplesOf3And5Fast(int bound) {
        int sum3 = sumMultiplesOf(3, bound);
        int sum5 = sumMultiplesOf(5, bound);
        int sum15 = sumMultiplesOf(15, bound);

        return (sum3 + sum5 - sum15);
    }

    private static int sumMultiplesOf(int num, int bound) {
        int count = (bound - 1) / num;
        return (num * count * (count + 1)) / 2;
    }
}
