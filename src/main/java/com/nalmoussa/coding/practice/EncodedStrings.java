package com.nalmoussa.coding.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class EncodedStrings {
    static String decodeUsingStacks(String encodedString) {
        Stack<String> stringStack = new Stack<>();
        DecodingMode mode = DecodingMode.WRITING_TO_STACK;
        String currentString;
        int multiplier = 1;
        StringBuilder numberBuilder = new StringBuilder();
        int index = encodedString.length() - 1;
        boolean done = false;
        while (!done) {
            switch (mode) {
                case WRITING_TO_STACK:
                    currentString = encodedString.substring(index, index + 1);
                    if ("[".equals(currentString)) {
                        mode = DecodingMode.NUMBER_READING;
                    } else {
                        stringStack.push(currentString);
                    }
                    if (--index < 0) {
                        mode = DecodingMode.FINAL_READ_FROM_STACK;
                    }
                    break;
                case NUMBER_READING:
                    currentString = encodedString.substring(index, index + 1);
                    if ("0123456789".contains(currentString)) {
                        numberBuilder.append(currentString);
                        index--;
                    }

                    if ((index < 0) || (!"0123456789".contains(currentString))) {
                        multiplier = Integer.parseInt(numberBuilder.reverse().toString());
                        numberBuilder = new StringBuilder();
                        mode = DecodingMode.READING_FROM_STACK;
                    }
                    break;
                case READING_FROM_STACK:
                    decodeAndRepush(stringStack, multiplier);
                    multiplier = 1;
                    mode = (index < 0) ? DecodingMode.FINAL_READ_FROM_STACK : DecodingMode.WRITING_TO_STACK;
                    break;
                case FINAL_READ_FROM_STACK:
                    decodeAndRepush(stringStack, multiplier);
                    done = true;
                    break;
            }
        }

        return stringStack.pop();
    }

    static String decode(String encodedString) {
        String decodedString;
        if (!encodedString.contains("[")) {
            decodedString = encodedString;
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();
            String oneDecodedString;
            List<Pair<Integer, String>> sequentialEncodedStrings = getSequentialEncodedStringsFrom(encodedString);
            for (Pair<Integer, String> pair : sequentialEncodedStrings) {
                oneDecodedString = decode(pair.getValue());
                for (int i = 0; i < pair.getKey(); i++) {
                    stringBuilder.append(oneDecodedString);
                }
            }

            decodedString = stringBuilder.toString();
        }
        return decodedString;
    }

    private enum DecodingMode {
        NUMBER_READING,
        READING_FROM_STACK,
        WRITING_TO_STACK,
        FINAL_READ_FROM_STACK
    }

    private static List<Pair<Integer, String>> getSequentialEncodedStringsFrom(String encodedString) {
        int index = 0;
        int key;
        char ch;
        StringBuilder stringBuilder;
        String value;
        List<Pair<Integer, String>> result = new ArrayList<>();
        do {
            stringBuilder = new StringBuilder();
            ch = encodedString.charAt(index);
            while (Character.isDigit(ch)) {
                stringBuilder.append(ch);
                index++;
                ch = encodedString.charAt(index);
            }
            key = (stringBuilder.length() == 0) ? 1 : Integer.parseInt(stringBuilder.toString());

            stringBuilder = new StringBuilder();
            if (key == 1) {
                // I'm expecting "abc" is next
                while (!Character.isDigit(ch)) {
                    stringBuilder.append(ch);
                    index++;
                    ch = (index < encodedString.length()) ? encodedString.charAt(index) : '0';
                }
                value = stringBuilder.toString();
            }
            else {
                // I'm expecting "[<encoded string>]" is next
                stringBuilder.append(ch);
                int bracketCounter = 1; // since we're starting with '['
                while (bracketCounter > 0) {
                    index++;
                    ch = encodedString.charAt(index);
                    stringBuilder.append(ch);
                    bracketCounter += (ch == '[') ? 1 : ((ch == ']') ? -1 : 0);
                }

                index++;
                value = stringBuilder.substring(1, stringBuilder.length()-1);
            }

            result.add(new Pair<>(key, value));
        } while (index < encodedString.length());

        return result;
    }

    private static String readAndConcat(Stack<String> stringStack) {
        StringBuilder stringBuilder = new StringBuilder();
        String currentString = (stringStack.isEmpty()) ? "]" : stringStack.pop();
        while (!"]".equals(currentString)) {
            stringBuilder.append(currentString);
            currentString = (stringStack.isEmpty()) ? "]" : stringStack.pop();
        }

        return stringBuilder.toString();
    }

    private static String multiple(String string, int multiplier) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < multiplier; i++) {
            stringBuilder.append(string);
        }

        return stringBuilder.toString();
    }

    private static void decodeAndRepush(Stack<String> stringStack, int multiplier) {
        String currentString = readAndConcat(stringStack);
        currentString = multiple(currentString, multiplier);
        stringStack.push(currentString);
    }
}

