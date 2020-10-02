package com.nalmoussa.coding.practice;

import java.util.ArrayList;
import java.util.List;

class WellFormedParentheses {
    private final static String OPEN_PARENTHESIS = "(";
    private final static String CLOSE_PARENTHESIS = ")";

    static List<String> generateWellFormedParentheses(int pairCount) {
        if (pairCount > 0) {
            return generateWellFormedParentheses(pairCount, pairCount);
        }
        else {
            throw new IllegalArgumentException(pairCount + " must be positive integer");
        }
    }

    static boolean isWellFormedParentheses(String str) {
        int counter = 0;
        for (char ch : str.toCharArray()) {
            switch (ch) {
                case '(':
                    counter += 1;
                    break;
                case ')':
                    counter -= 1;
                    break;
                default:
                    counter = -1;
            }
            if (counter < 0) {
                break;
            }
        }
        return (counter == 0);
    }

    private static List<String> generateWellFormedParentheses(int open, int close) {
        List<String> results = new ArrayList<>();
        if (open <= close) {
            if (open + close == 1) {
                // There's only one ")"
                results.add(CLOSE_PARENTHESIS);
            }
            else {
                if (open > 0) {
                    results.addAll(prefixAll(OPEN_PARENTHESIS, generateWellFormedParentheses(open - 1, close)));
                }
                if (close > 0) {
                    results.addAll(prefixAll(CLOSE_PARENTHESIS, generateWellFormedParentheses(open, close - 1)));
                }
            }
        }

        return results;
    }

    private static List<String> prefixAll(String parentheses, List<String> combinations) {
        List<String> results = new ArrayList<>();
        for (String str : combinations) {
            results.add(parentheses + str);
        }
        return results;
    }
}
