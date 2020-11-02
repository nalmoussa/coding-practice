package com.nalmoussa.coding.practice.problem028;
/*
* Given A and B two interval lists, A has no overlap inside A and B has no overlap inside B.
* Write the function to merge two interval lists, output the result with no overlap.
*
* For example,
* A: [1,5], [10,14], [16,18]
* B: [2,6], [8,10], [11,20]
*
* output [1,6], [8, 20]
*/


import java.util.ArrayList;
import java.util.List;

public class MergeTwoListsOfIntervals {
    private static final int START = 0;
    private static final int END = 1;

    public static void main(String[] args) {
        int[][] intervalList1 = {{1, 5}, {10, 14}, {16, 18}};
        int[][] intervalList2 = {{2, 6}, {8, 10}, {11, 20}};
        int[][] resultIntervalList = merge(intervalList1, intervalList2);

        printIntervals(intervalList1);
        System.out.println("=======");
        printIntervals(intervalList2);
        System.out.println("=======");
        printIntervals(resultIntervalList);
    }

    private static int[][] merge(int[][] intervals1, int[][] intervals2) {
        List<int[]> intervalList = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;

        int[] currentInterval = intervals1[index1++];
        while (index1 < intervals1.length || index2 < intervals2.length) {
            int[] interval1 = (index1 < intervals1.length) ? intervals1[index1] : new int[0];
            int[] interval2 = (index2 < intervals2.length) ? intervals2[index2] : new int[0];

            boolean currentAnd1AreDisjoint = isDisjoint(currentInterval, interval1);
            boolean currentAnd2AreDisjoint = isDisjoint(currentInterval, interval2);

            if (currentAnd1AreDisjoint && currentAnd2AreDisjoint) {
                intervalList.add(currentInterval);
                currentInterval = interval1;
                index1++;
            }

            if (!currentAnd1AreDisjoint) {
                currentInterval = join(currentInterval, interval1);
                index1++;
            }

            if (!currentAnd2AreDisjoint) {
                currentInterval = join(currentInterval, interval2);
                index2++;
            }
        }
        intervalList.add(currentInterval);

        return intervalList.toArray(int[][]::new);
    }

    private static int[] join(int[] interval1, int[] interval2) {
        int[] result = null;
        if (isValid(interval1) && isValid(interval2)) {
            int[] leftInterval = (interval1[START] < interval2[START]) ? interval1 : interval2;
            int[] rightInterval = (interval1[START] < interval2[START]) ? interval2 : interval1;

            result = new int[2];
            result[START] = leftInterval[START];

            result[END] = Math.max(rightInterval[END], leftInterval[END]);
        }
        return result;
    }

    private static boolean isDisjoint(int[] interval1, int[] interval2) {
        boolean result = true;
        if (isValid(interval1) && isValid(interval2)) {
            int leftEnd, rightStart;
            if (interval1[START] < interval2[START]) {
                leftEnd = interval1[END];
                rightStart = interval2[START];
            } else {
                leftEnd = interval2[END];
                rightStart = interval1[START];
            }

            result = leftEnd < rightStart;
        }
        return result;
    }

    private static boolean isValid(int[] interval) {
        return !(interval == null || interval.length < 2 || interval[0] > interval[1]);
    }

    private static void printIntervals(int[][] intervals) {
        if (intervals != null) {
            for (int[] interval : intervals) {
                printInterval(interval[START], interval[END]);
            }
            System.out.println();
        }
    }

    private static void printInterval(int start, int end) {
        String startAsString = fixedLengthNumber(start);
        String endAsString = fixedLengthNumber(end);
        System.out.printf("[%s,%s] ", startAsString, endAsString);
    }

    private static String fixedLengthNumber(int num) {
        String withExtraSpace = "              " + num;
        int length = withExtraSpace.length();
        return withExtraSpace.substring(length - 3);
    }
}
