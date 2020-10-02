package com.nalmoussa.coding.practice;

import java.util.ArrayList;
import java.util.List;

public class PowersOfTwo {
    private List<Integer> digits;

    public PowersOfTwo(int power) throws IllegalArgumentException {
        if ((power > -1) && (power < 1201)) {
            digits = new ArrayList<>();
            digits.add(1);
            for (int p = 0; p < power; p++) {
                doubleUp();
            }
        }
        else {
            throw new IllegalArgumentException("Illegal Argument");
        }
    }

    private void doubleUp() {
        List<Integer> newDigits = new ArrayList<>();
        int carryOver = 0;
        for (Integer digit : digits) {
            int doubleDigit = 2 * digit;
            newDigits.add((doubleDigit + carryOver) % 10);
            carryOver = (doubleDigit + carryOver) / 10;
        }

        if (carryOver > 0) {
            newDigits.add(carryOver);
        }
        digits = newDigits;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int lastIndex = digits.size() - 1;
        for (int i = 0; i < digits.size(); i++) {
            Integer digit = digits.get(lastIndex-i);
            stringBuilder.append(digit.toString());
            if ((i > 0) && (i % 40 == 0)) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public int sum() {
        int total = 0;
        for (Integer digit : digits) {
            total += digit;
        }
        return total;
    }
}
