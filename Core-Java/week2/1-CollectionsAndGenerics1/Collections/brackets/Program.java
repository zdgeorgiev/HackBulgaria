package brackets;

import java.util.Stack;

public class Program {
    public static void main(String[] args) {
        String expression = "(()()";
        Stack<Integer> brackets = new Stack<Integer>();

        boolean isValid = true;

        if (expression.indexOf(0) != '(') {
            for (int i = 0; i < expression.length(); i++) {
                Character currentBracket = expression.charAt(i);

                if (currentBracket == '(') {
                    brackets.push(1);
                } else {
                    if (!brackets.empty()) {
                        brackets.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }
        }

        System.out.println(isValid && brackets.isEmpty());
    }
}