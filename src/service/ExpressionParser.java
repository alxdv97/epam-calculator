package service;

import java.util.LinkedList;

public class ExpressionParser {

    private static boolean isDelimiter(char c) {
        return c == ' ';
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    private static int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }

    private static void processOperator(LinkedList<Double> st, char op) {
        double r = st.removeLast();
        double l = st.removeLast();
        switch (op) {
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                st.add(l / r);
                break;
            case '%':
                st.add(l % r);
                break;
        }
    }

    public static double eval(String s) {
        Validator.validateExpression(s);
        LinkedList<Double> st = new LinkedList<>();
        LinkedList<Character> op = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDelimiter(c))
                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st, op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperator(st, op.removeLast());
                op.add(c);
            } else {
                StringBuilder operand = new StringBuilder();
                while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
                    operand.append(s.charAt(i++));
                }
                --i;
                st.add(Double.parseDouble(operand.toString()));
            }
        }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0);
    }
}
