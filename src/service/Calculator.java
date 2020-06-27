package service;

public class Calculator {
    public static void main(String[] args) {
        ConsoleHelper.writeString("Введите выражение:");
        double result = ExpressionParser.eval(ConsoleHelper.readString());
        Validator.validateAnswer(result);
        ConsoleHelper.writeString("Результат: "+String.format("%.2f", result));
    }
}
