package com.nalmoussa.coding.practice.problem010;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class LargeNumber {
    private String number;

    LargeNumber(String number) {
        this.number = number;
    }

    private String[] asStringArray() {
        return number.split("");
    }

    private int[] asIntArray() {
        String[] stringArray = asStringArray();
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        return intArray;
    }

    LargeNumber multiply(int multiplier) {
        int[] intArray = asIntArray();
        StringBuilder stringBuilder = new StringBuilder();
        int onesColumn;
        int tensColumn = 0;
        int result;
        for (int i = intArray.length - 1; i >= 0; i--) {
            result = (multiplier * intArray[i] + tensColumn);
            onesColumn = result % 10;
            tensColumn = result / 10;
            stringBuilder.append(onesColumn);
        }
        if (tensColumn > 0) {
            stringBuilder.append(tensColumn);
        }
        number = stringBuilder.reverse().toString();
        return this;
    }

    LargeNumber multiplyByPowerOfTen(int powerOfTen) {
        number = number +
            "0".repeat(Math.max(0, powerOfTen));
        return this;
    }

    LargeNumber multiplyFast(LargeNumber other) {
        int[] multiplier = other.asIntArray();
        LargeNumber temp;
        LargeNumberMultiplier largeNumberMultiplier;
        List<LargeNumberMultiplier> largeNumberMultiplierList = new ArrayList<>();
        for (int i = 0; i < multiplier.length; i++) {
            temp = new LargeNumber(number);
            largeNumberMultiplier = new LargeNumberMultiplier(temp, multiplier[i], multiplier.length - 1 - i);
            largeNumberMultiplierList.add(largeNumberMultiplier);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            List<Future<LargeNumber>> result = executorService.invokeAll(largeNumberMultiplierList);
            LargeNumber newNumber = addAll(result);
            number = newNumber.toString();
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        return this;
    }

    LargeNumber multiply(LargeNumber other) {
        LargeNumber result = new LargeNumber("0");
        int[] multiplier = other.asIntArray();
        LargeNumber temp;
        for (int i = 0; i < multiplier.length; i++) {
            temp = new LargeNumber(number);
            temp = temp.multiply(multiplier[i]);
            temp = temp.multiplyByPowerOfTen(multiplier.length - 1 - i);
            result.add(temp);
        }

        number = result.number;
        return this;
    }

    private void shiftToTheRight(int offset) {
        number = "0".repeat(Math.max(0, offset)) +
            number;
    }

    LargeNumber add(LargeNumber other) {
        int lengthDifference = number.length() - other.number.length();
        if (lengthDifference > 0) {
            // this is longer than other
            other.shiftToTheRight(lengthDifference);
        } else {
            // other is longer than this
            shiftToTheRight(Math.abs(lengthDifference));
        }

        int[] firstIntArray = asIntArray();
        int[] secondIntArray = other.asIntArray();
        StringBuilder stringBuilder = new StringBuilder();
        int onesColumn;
        int tensColumn = 0;
        int result;
        for (int i = firstIntArray.length - 1; i >= 0; i--) {
            result = firstIntArray[i] + secondIntArray[i] + tensColumn;
            onesColumn = result % 10;
            tensColumn = result / 10;
            stringBuilder.append(onesColumn);
        }
        if (tensColumn > 0) {
            stringBuilder.append(tensColumn);
        }
        number = stringBuilder.reverse().toString();
        return this;
    }

    private LargeNumber addAll(List<Future<LargeNumber>> futureList) {
        LargeNumber result = new LargeNumber("0");
        for (Future<LargeNumber> future : futureList) {
            try {
                result.add(future.get());
            } catch (ExecutionException | InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }

        number = result.number;
        return this;
    }

    @Override
    public String toString() {
        return number;
    }
}

