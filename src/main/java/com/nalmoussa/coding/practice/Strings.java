package com.nalmoussa.coding.practice;

import java.util.ArrayList;
import java.util.List;

public class Strings {
    private static final String EMPTY_STRING = "";

    public static List<String> permute(String input) {
        List<String> output = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            return output;
        }

        if (input.length() == 1) {
            output.add(input);
            return output;
        }

        int charPosition = 0;
        char ch = input.charAt(charPosition);
        String remainingInput = input.substring(1);
        List<String> tempOutput = permute(remainingInput);
        for (int pos = 0; pos < input.length(); pos++) {
            for (String temp : tempOutput) {
                output.add(concatAt(temp, ch, pos));
            }
        }

        return output;
    }

    public static List<String> permuteDynamic(String input) {
        List<String> output = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            return output;
        }

        output.add("");
        for (char ch : input.toCharArray()) {
            List<String> tempOutput = new ArrayList<>();
            for(String str : output) {
                for(int pos = 0; pos < str.length() + 1; pos++) {
                    tempOutput.add(concatAt(str, ch, pos));
                }
            }
            output = tempOutput;
        }
        return output;
    }

    public static boolean isInteger(String str) {
        return isInteger(str, true);
    }

    static boolean isInteger(String str, boolean allowSign) {
        String regexWithSign = "0|\\+?[1-9]|\\+?[1-9]([0-9]+)|-?[1-9]|-?[1-9]([0-9]+)";
        String regexWithoutSign = "[0-9]|[1-9]([0-9]+)";
        String regex = allowSign ? regexWithSign : regexWithoutSign;
        return ((str != null) && (str.matches(regex)));
    }

    private static String concatAt(String str, char ch, int position) {
        StringBuilder builder = new StringBuilder(str);
        return builder.insert(position, ch).toString();
    }

    public static String findLongestSubstringWithoutRepeating(String input) {
        if (input == null) {
            return null;
        }

        String currentSubstring = EMPTY_STRING;
        String longestSubstring = EMPTY_STRING;

        for (int i = 0; i < input.length(); i++) {
            String ch = input.substring(i,i+1);
            if (currentSubstring.contains(ch)) {
                longestSubstring = getLonger(longestSubstring, currentSubstring);
                currentSubstring = EMPTY_STRING;
            }
            currentSubstring = currentSubstring.concat(ch);
        }
        longestSubstring = getLonger(longestSubstring, currentSubstring);

        return longestSubstring;
    }

    static String keepParentheses(String input) {
        String output = null;
        if (input != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : input.toCharArray()) {
                if (ch == '(' || ch == ')') {
                    stringBuilder.append(ch);
                }
            }
            output = stringBuilder.toString();
        }

        return output;
    }

    static String removeParentheses(String input) {
        String output = null;
        if (input != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : input.toCharArray()) {
                if (ch == '(' || ch == ')') {
                    continue;
                }
                stringBuilder.append(ch);
            }

            output = stringBuilder.toString();
        }

        return output;
    }

    static String generateLongString(int length, char ch) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    private static String getLonger(String str1, String str2) {
        int length1 = (str1 == null) ? -1 : str1.length();
        int length2 = (str2 == null) ? -1 : str2.length();
        return (length1 >= length2) ? str1 : str2;
    }

    static boolean isUpperCaseLetter(char ch) {
        return ((ch >= 'A') && (ch <= 'Z'));
    }

    static boolean isLowerCaseLetter(char ch) {
        return ((ch >= 'a') && (ch <= 'z'));
    }

}
