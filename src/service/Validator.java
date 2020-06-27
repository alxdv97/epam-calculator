package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void validateExpression(String s){
        Pattern notNumberOrOperator = Pattern.compile("[^\\s\\d\\+\\*\\/\\.\\-\\(\\)]");
        Matcher matcherNotNumberOrOperator = notNumberOrOperator.matcher(s);
        Pattern duplicateOperator = Pattern.compile("\\+{2,}|\\-{2,}|\\.{2,}|\\*{2,}|\\/{2,}|\\s{2,}");
        Matcher matcherDuplicateOperator = duplicateOperator.matcher(s);
        if (matcherNotNumberOrOperator.find()){ // не число или оператор
            throw new UnsupportedOperationException("Некорректные данные!");
        }
        if (matcherDuplicateOperator.find()){ // повторяющиеся символы
            throw new UnsupportedOperationException("Некорректные данные!");
        }
    }

    public static void validateAnswer(double d){
        if (Double.isInfinite(d)){
            throw new UnsupportedOperationException("Деление на ноль!");
        }
    }
}
