package com.nalmoussa.coding.practice.problem008;

import java.util.Stack;

class ReversePolishNotation {
    static int evaluate(String[] input) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        Integer operand1, operand2;
        OperatorType operatorType;
        for (String next : input) {
            operatorType = typeOf(next);
            if (operatorType == OperatorType.OPERAND) {
                stack.push(operand);
                operand = Integer.parseInt(next);
            }
            else {
                operand1 = stack.pop();
                operand2 = operand;
                switch (operatorType) {
                    case ADDITION:
                        operand = operand1 + operand2;
                        break;
                    case MINUS:
                        operand = operand1 - operand2;
                        break;
                    case DIVISION:
                        operand = operand1 / operand2;
                        break;
                    case MULTIPLICATION:
                        operand = operand1 * operand2;
                        break;
                }
            }
        }

        return operand;
    }

    private enum OperatorType {
        ADDITION,
        MINUS,
        MULTIPLICATION,
        DIVISION,
        OPERAND
    }

    private static OperatorType typeOf(String str) {
        String[] operatorName = {"ADDITION", "MINUS", "MULTIPLICATION", "DIVISION", "OPERAND"};
        int index = "+-*/".indexOf(str);
        index = (index < 0) ? 4 : index;
        String name = operatorName[index];
        return OperatorType.valueOf(name);
    }
}
