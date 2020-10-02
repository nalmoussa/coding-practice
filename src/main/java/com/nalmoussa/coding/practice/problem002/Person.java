package com.nalmoussa.coding.practice.problem002;

class Person extends Interval {
    private static final int MAX_AGE = 120;
    Person(int birthYear, int deathYear) {
        if (isValid(birthYear, deathYear)) {
            this.firstYear = birthYear;
            this.lastYear = deathYear;
        }
        else {
            throw new IllegalArgumentException("Illegal Arguments");
        }
    }

    private static boolean isValid(int birthYear, int deathYear) {
        return (
                (Timeline.MIN <= birthYear) &&
                (birthYear <= deathYear)    &&
                (deathYear <= Timeline.MAX) &&
                (deathYear - birthYear < MAX_AGE)
        );
    }

    int getBirthYear() {
        return this.firstYear;
    }

    int getDeathYear() {
        return this.lastYear;
    }
}
