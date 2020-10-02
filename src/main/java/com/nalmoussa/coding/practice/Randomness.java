package com.nalmoussa.coding.practice;

import java.util.Random;

class Randomness {
    private static Random rand = new Random();

    static int rand(int base) {
        switch (base) {
            case 2:
                return rand2();
            case 4:
                return rand4();
            case 5:
                return rand5();
            case 6:
                return rand6();
            case 7:
                return rand7();
            default:
                throw new IllegalArgumentException(String.format("%s isn't supported base", base));
        }
    }

    // Returns either 0 or 1
    private static int randCoin() {
        return rand.nextInt(2);
    }

    // Return either 1 or 2
    private static int rand2() {
        return randCoin() + 1;
    }

    // Returns integer between 1 and 4
    private static int rand4() {
        int r5 = rand5();
        while (r5 == 5) {
            r5 = rand5();
        }
        return r5;
    }

    // Returns integer between 1 and 5
    private static int rand5() {
        return rand.nextInt(5) + 1;
    }

    // Returns integer between 1 and 6
    private static int rand6() {
        int a = randCoin();
        int b = randCoin();
        int c = randCoin();
        String binaryStr = String.format("%d%d%d", a,b,c);
        int d = Integer.parseInt(binaryStr, 2);
        while ((d == 0) || (d == 7)) {
            a = randCoin();
            b = randCoin();
            c = randCoin();
            binaryStr = String.format("%d%d%d", a,b,c);
            d = Integer.parseInt(binaryStr, 2);
        }
        return d;
    }

    // Returns integer between 1 and 7
    private static int rand7() {
        int a = rand4() % 2;
        int b = rand4() % 2;
        int c = rand4() % 2;
        String binaryStr = String.format("%d%d%d", a,b,c);
        int d = Integer.parseInt(binaryStr, 2);
        while (d == 0) {
            a = rand4() % 2;
            b = rand4() % 2;
            c = rand4() % 2;
            binaryStr = String.format("%d%d%d", a,b,c);
            d = Integer.parseInt(binaryStr, 2);
        }
        return d;
    }
}
