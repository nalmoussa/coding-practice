package com.nalmoussa.coding.practice.problem005;

public class EditDistance {
    static boolean oneEditApart(String s1, String s2) {
        // Verify s1, s2 are valid
        // Can not be null
        // Handle cases where one or both strings are empty
        boolean result;
        if (s1.equals(s2) || Math.abs(s1.length()-s2.length()) > 1) {
            return false;
        }

        boolean sameLength = s1.length() == s2.length();
        if (sameLength) {
            result = oneEditApart(s1, s2, 1);
        }
        else {
            boolean firstIsShorter = s1.length() < s2.length();
            String shortString = (firstIsShorter) ? s1 : s2;
            String longString  = (firstIsShorter) ? s2 : s1;
            result = oneEditApart(shortString, longString, 0);
        }
        return result;
    }

    private static boolean compareEqualityOfSubStrings(String s1, String s2, int index1, int index2) {
        s1 = s1.substring(index1);
        s2 = s2.substring(index2);
        return s1.equals(s2);
    }

    private static int findIndexOfFirstDiff(String s1, String s2) {
        int i = 0;
        while (i < s1.length() && (s1.charAt(i) == s2.charAt(i))) {
            i++;
        }
        return i;
    }

    private static boolean oneEditApart(String s1, String s2, int offset) {
        boolean result = true;
        int i = findIndexOfFirstDiff(s1, s2);
        if (i < s1.length()) {
            result = compareEqualityOfSubStrings(s1, s2, i + offset, i + 1);
        }
        return result;
    }
}
