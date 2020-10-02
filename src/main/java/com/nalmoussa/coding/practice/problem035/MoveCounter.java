package com.nalmoussa.coding.practice.problem035;

import java.util.Arrays;
import java.util.List;

public class MoveCounter {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 16);
        System.out.println(countMoves(numbers));
    }

    static long countMoves(List<Integer> numbers) {
        long moves = 0;
        while (!areTheSame(numbers)) {
            printValues(numbers);
            int skipIndex = findIndexOfMax(numbers);
            increaseValues(numbers, skipIndex);
            moves++;
        }

        return moves;
    }

    private static boolean areTheSame(List<Integer> numbers) {
        if (numbers.size() > 1) {
            Integer value = numbers.get(0);
            for (int index = 1; index < numbers.size(); index++) {
                if (!value.equals(numbers.get(index))) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int findIndexOfMax(List<Integer> numbers) {
        int indexOfMax = 0;
        if (numbers.size() > 1) {
            Integer maxValue = numbers.get(0);
            for (int index = 1; index < numbers.size(); index++) {
                if (maxValue < numbers.get(index)) {
                    indexOfMax = index;
                    maxValue = numbers.get(index);
                }
            }
        }

        return indexOfMax;
    }

    private static void increaseValues(List<Integer> numbers, int skipIndex) {
        int oldValue, newValue;
        for (int index = 0; index < numbers.size(); index++) {
            oldValue = numbers.get(index);
            newValue = (skipIndex == index) ? oldValue : oldValue + 1;
            numbers.set(index, newValue);
        }
    }

    private static void printValues(List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
