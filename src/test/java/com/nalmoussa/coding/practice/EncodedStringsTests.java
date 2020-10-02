package com.nalmoussa.coding.practice;

public class EncodedStringsTests {
    public static void main(String[] args) {
        String[] validEncodedString = {"abc", "xyz4[ab]", "3[ab]2[cd]", "3[a2[cb]]ef", "2[2[a3[bc]]]", "2[a12[b]]3[de]f"};
        for (String encodedString : validEncodedString) {
            System.out.println(encodedString + " > ");
            System.out.println(EncodedStrings.decode(encodedString));
            System.out.println(EncodedStrings.decodeUsingStacks(encodedString));
            System.out.println();
        }
    }
}
