package calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {
    private String expression;
    private ArrayList<String> expressionToRPN;

    private Map<Character, Integer> operators;

    public Calculator() {
        this.expressionToRPN = new ArrayList<String>();

        // operators represented as <Operator, Priority>
        this.operators = new HashMap<Character, Integer>();

        this.operators.put('!', 3);
        this.operators.put('^', 2);
        this.operators.put('*', 2);
        this.operators.put('/', 2);
        this.operators.put('+', 1);
        this.operators.put('-', 1);
        this.operators.put('(', 0);
        this.operators.put(')', 0);
    }

    public float calc() {
        float result = 0.0f;

        ArrayList<String> cpy = this.expressionToRPN;

        for (int i = 0; cpy.size() > i; i++) {
            String token = cpy.get(i);

            // If current token is number
            if (Character.isDigit(token.charAt(0))) {

            } else {
                switch (token) {
                // First check for right associative operators
                    case "!":
                        if (i > 0) {
                            ProcessOperation(token, i, cpy);
                            i -= 1;
                        }

                        break;

                    // Left associative operators
                    default:
                        if (i > 1) {
                            ProcessOperation(token, i, cpy);
                            i -= 2;
                        }

                        break;
                }
            }
        }

        result = Float.parseFloat(cpy.get(0));

        return result;
    }

    private void ProcessOperation(String operation, int index, ArrayList<String> arr) {
        if (operation.equals("!")) {
            float number = Float.parseFloat(arr.get(index - 1));

            switch (operation) {
                case "!":
                    float fac = 1;
                    for (int i = 2; i <= number; i++) {
                        fac *= i;
                    }

                    arr.set(index - 1, String.valueOf(fac));
                    break;

                default:
                    System.out.println("Invalid operation");
                    break;
            }

            arr.remove(index);
        } else {
            float leftNumber = Float.parseFloat(arr.get(index - 2));
            float rightNumber = Float.parseFloat(arr.get(index - 1));

            switch (operation) {
                case "^":
                    arr.set(index - 2, String.valueOf(Math.pow(leftNumber, rightNumber)));
                    break;
                case "*":
                    arr.set(index - 2, String.valueOf(leftNumber * rightNumber));
                    break;
                case "/":
                    arr.set(index - 2, String.valueOf(leftNumber / rightNumber));
                    break;
                case "+":
                    arr.set(index - 2, String.valueOf(leftNumber + rightNumber));
                    break;
                case "-":
                    arr.set(index - 2, String.valueOf(leftNumber - rightNumber));
                    break;

                default:
                    System.out.println("Invalid operation");
                    break;
            }

            // Remove the operator and the right operand
            // because when removes the first number
            // the next position we want to delete is also index - 1
            arr.remove(index - 1);
            arr.remove(index - 1);
        }
    }

    private void convertToRPN(String expression) {
        Stack<Character> tempOperators = new Stack<Character>();

        for (int i = 0; i < expression.length(); i++) {
            Character token = expression.charAt(i);

            if (token >= '0' && token <= '9') {
                StringBuilder currentNumber = new StringBuilder();
                currentNumber.append(token);

                // Check if the number isn't just with one digit ;)
                while (i + 1 < expression.length()) {
                    if (expression.charAt(i + 1) >= '0' && expression.charAt(i + 1) <= '9') {
                        currentNumber.append(expression.charAt(i + 1));
                        i++;
                    } else {
                        break;
                    }
                }

                this.expressionToRPN.add(currentNumber.toString());
            } else {
                switch (token) {
                // Operators with right associativity
                    case '^':
                    case '!':
                        while (!tempOperators.isEmpty()) {
                            if (this.operators.get(token) < this.operators.get(tempOperators.peek())) {
                                this.expressionToRPN.add(tempOperators.pop().toString());
                            } else {
                                break;
                            }
                        }

                        tempOperators.push(token);
                        break;

                    case '(':
                        tempOperators.push(token);
                        break;

                    case ')':
                        while (tempOperators.peek() != '(') {
                            this.expressionToRPN.add(tempOperators.pop().toString());
                        }

                        tempOperators.pop();
                        break;

                    // Operators with left associativity ( +, -, *, / )
                    default:
                        while (!tempOperators.isEmpty()) {
                            if (this.operators.get(token) <= this.operators.get(tempOperators.peek())) {
                                this.expressionToRPN.add(tempOperators.pop().toString());
                            } else {
                                break;
                            }
                        }

                        tempOperators.push(token);
                        break;
                }
            }
        }

        while (!tempOperators.isEmpty()) {
            this.expressionToRPN.add(tempOperators.pop().toString());
        }
    }

    public String getExpression() {
        return this.expression;
    }

    public void setExpression(String expression) {
        // Remove all blank spaces
        StringBuilder fixed = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ' ') {
                continue;
            }

            fixed.append(expression.charAt(i));
        }

        this.expression = fixed.toString();
        this.convertToRPN((this.getExpression()));
    }

    public String getExpressionToRPN() {
        StringBuilder output = new StringBuilder();

        for (String str : this.expressionToRPN) {
            output.append(str + " ");
        }

        return output.toString().trim();
    }
}