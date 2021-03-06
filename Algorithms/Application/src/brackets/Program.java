package brackets;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Program {
    public static void main(String[] args) {

        List<String> expressions = Arrays.asList("[123(145)38(37)812]", "{125[2][(1)][3]125}", "[125()125()125()125]",
                "(123)", "[(123)(123)]", "[23(123)12(123)]", "{123[123(123)123(123)]23[123]2}", "[123]", "{123}",
                "{125()125}", "{125[12]{125}[12]125}", "{125[12(123]125}", "(123)(123)", "[123{123}]", "[123(123])",
                "(123[123])", "123(123)");

        for (int i = 0; i < expressions.size(); i++) {
            System.out.println(CalcTheExpression(expressions.get(i)));
        }
    }

    private static boolean isValidExpression(String expression) {
        if (!checkForOutermostBrackets(expression)) {
            return false;
        }

        // Hold the available brackets in the current scope of brackets
        Stack<BracketsHolder> availableBrackets = new Stack<BracketsHolder>();
        Boolean isValid = true;

        for (int i = 0; i < expression.length(); i++) {
            Character currentChar = expression.charAt(i);

            switch (currentChar) {
                case '(':
                case '[':
                case '{':
                    isValid = createNewBracketScope(availableBrackets, currentChar, i == 0);
                    break;

                case ')':
                case ']':
                case '}':
                    isValid = removeLastBracketScope(availableBrackets, currentChar);
                    break;
            }

            if (!isValid) {
                return false;
            }
        }

        return true;
    }

    private static boolean createNewBracketScope(Stack<BracketsHolder> destination, Character bracket,
            boolean firstScope) {

        if (destination.size() != 0) {
            switch (bracket) {
                case '(':
                    if (!destination.peek().isRoundBracketAvaible) {
                        return false;
                    }
                    break;
                case '[':
                    if (!destination.peek().isSquareBracketAvaible) {
                        return false;
                    }
                    break;
                case '{':
                    if (!destination.peek().isCurlyBracketAvaible) {
                        return false;
                    }
                    break;
            }
        } else {
            if (!firstScope) {
                return false;
            }
        }

        switch (bracket) {
            case '(':
                destination.add(new BracketsHolder(false, false, false));
                destination.peek().roundBracketsCount++;
                break;
            case '[':
                destination.add(new BracketsHolder(true, false, false));
                destination.peek().squareBracketsCount++;
                break;
            case '{':
                destination.add(new BracketsHolder(false, true, false));
                destination.peek().curlyBracketsCount++;
                break;
        }

        return true;
    }

    private static boolean removeLastBracketScope(Stack<BracketsHolder> source, Character bracket) {

        if (source.size() == 0) {
            return false;
        }

        BracketsHolder currentHolder = source.peek();

        switch (bracket) {
            case ')':
                currentHolder.roundBracketsCount--;
                break;
            case ']':
                currentHolder.squareBracketsCount--;
                break;
            case '}':
                currentHolder.curlyBracketsCount--;
                break;
        }

        if (!source.pop().isClean()) {
            return false;
        }

        return true;
    }

    private static boolean checkForOutermostBrackets(String expression) {
        Character firstChar = expression.charAt(0);
        Character lastChar = expression.charAt(expression.length() - 1);

        switch (firstChar) {
            case '(':
                return lastChar == ')';
            case '[':
                return lastChar == ']';
            case '{':
                return lastChar == '}';

                // If the expression is not start with open bracket is invalid
            default:
                return false;
        }
    }

    private static String CalcTheExpression(String expression) {
        if (!isValidExpression(expression)) {
            return "NO";
        }

        int result = 0;
        int multiplier = 1;

        StringBuilder currentNumber = new StringBuilder();

        // Don't move through first most left bracket
        for (int i = 1; i < expression.length(); i++) {
            Character currentChar = expression.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber.append(currentChar);
            } else {
                if (currentNumber.length() != 0) {
                    result += multiplier * Integer.parseInt(currentNumber.toString());
                    currentNumber = new StringBuilder();
                }

                if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                    multiplier *= 2;
                } else if (currentChar == ')' || currentChar == ']' || currentChar == '}') {
                    multiplier /= 2;
                }
            }
        }

        return String.valueOf(result);
    }
}