package com.nalmoussa.coding.practice.problem006;

class LookAndSay {
    static String next(String num) {
        if (num == null) {
            num = "";
        }

        boolean isValid = true;
        if (!num.isEmpty()) {
            for (char ch : num.toCharArray()) {
                if (ch < '1' || ch > '9') {
                    isValid = false;
                    break;
                }
            }
        }

        if (isValid) {
            StringBuilder result = new StringBuilder();
            int counter = 1;
            String currentChar = num.isEmpty() ? "" : num.substring(0,1);
            for (int i = 1; i < num.length(); i++) {
                String newChar = num.substring(i,i+1);
                if (currentChar.equals(newChar)) {
                    counter++;
                }
                else {
                    result.append(counter).append(currentChar);
                    currentChar = newChar;
                    counter = 1;
                }
            }

            result.append(counter).append(currentChar);
            return result.toString();
        }
        else {
            throw new IllegalArgumentException(num + " is invalid input");
        }
    }
}
