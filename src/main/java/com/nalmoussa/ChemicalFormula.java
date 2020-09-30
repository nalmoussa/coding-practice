package com.nalmoussa;

class ChemicalFormula {
    private com.nalmoussa.NumberOfAtoms numberOfAtoms;

    com.nalmoussa.NumberOfAtoms getNumberOfAtoms() {
        return numberOfAtoms;
    }

    ChemicalFormula(String input) {
        if (!isValidFormula(input)) {
            throw new IllegalArgumentException("The normalizedFormula: \"" + input + "\" is invalid");
        }

        input = normalize(input);
        this.numberOfAtoms = process(input);
    }

    private static boolean isValidFormula(String input) {
        return  (input != null)
                && (!input.equals(""))
                && (input.length() < 1001)
                && (!input.matches(".*\\s.*"))
                && (Strings.removeParentheses(input).matches("\\w+"))
                && com.nalmoussa.WellFormedParentheses.isWellFormedParentheses(Strings.keepParentheses(input));
    }

    private static String normalize(String formula) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean shouldOneBeAdded;
        char ch, nextCh;
        char lastCh = formula.charAt(formula.length()-1);
        for (int index = 0; index < formula.length() - 1; index++) {
            ch = formula.charAt(index);
            nextCh = formula.charAt(index+1);

            shouldOneBeAdded =
                    ((Strings.isUpperCaseLetter(ch) || Strings.isLowerCaseLetter(ch) || (ch == ')')) &&
                     (Strings.isUpperCaseLetter(nextCh) || (nextCh == ')')));

            stringBuilder.append(ch);
            if (shouldOneBeAdded) {
                stringBuilder.append('1');
            }
        }

        stringBuilder.append(lastCh);
        if (!Character.isDigit(lastCh)) {
            stringBuilder.append('1');
        }

        return stringBuilder.toString();
    }

    private com.nalmoussa.NumberOfAtoms process(String formula) {
        com.nalmoussa.NumberOfAtoms numberOfAtoms = new com.nalmoussa.NumberOfAtoms();
        String atomicElement;
        Integer count;
        boolean startsWithFormula;
        int beginIndex, counter;
        char ch;
        int endIndex = 0;

        while (endIndex < formula.length()) {
            startsWithFormula = (formula.charAt(endIndex) == '(');
            if (startsWithFormula) {
                counter = 1;
                endIndex++;
                beginIndex = endIndex;
                while (counter > 0) {
                    ch = formula.charAt(endIndex);
                    if (ch == '(') {
                        counter++;
                    } else if (ch == ')') {
                        counter--;
                    }
                    endIndex++;
                }

                atomicElement = formula.substring(beginIndex, endIndex - 1);
            }
            else {
                beginIndex = endIndex;
                while (!Character.isDigit(formula.charAt(endIndex))) {
                    endIndex++;
                }

                atomicElement = formula.substring(beginIndex, endIndex);
            }

            beginIndex = endIndex;
            while (endIndex < formula.length() && Character.isDigit(formula.charAt(endIndex))) {
                endIndex++;
            }
            count = Integer.parseInt(formula.substring(beginIndex, endIndex));

            if (startsWithFormula) {
                numberOfAtoms.add(process(atomicElement).multiplyBy(count));
            }
            else {
                numberOfAtoms.add(atomicElement, count);
            }
        }

        return numberOfAtoms;
    }
}