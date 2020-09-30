package com.nalmoussa;

import org.junit.Test;

public class EditDistanceTests {
    @Test
    public void verifyOneEditApartWorksAsExpected() {
        String s1 = "abb";
        String s2 = "abb";
        boolean result = EditDistance.oneEditApart(s1, s2);
        if (result) {
            System.out.println("YES!!!");
            System.out.println(s1 + " and " + s2 + " are one edit apart");
        }
        else {
            System.out.println("NO!!!");
            System.out.println(s1 + " and " + s2 + " are not one edit apart");

        }
    }
}
