package Advanced;

import java.util.*;

public class InfixToPostfix {

    static String toPostfix(String infix) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String sep = infix
                .replace("+", " + " + "+")
                .replace("/", " " + "/")
                .replace("-", " " + "-")
                .replace("*", " " + "*");
        String[] parts = sep.split(" ");


        for (String part : parts) {
            System.out.print(part + " ");
        }
        for (String val : parts) {


            if (!isOperator(val)) {
                sb.append(val);
            } else if (val.equals("(")) {
                stack.push(val);
            } else if (val.equals(")")) {
                while (!stack.isEmpty() && !Objects.equals(stack.peek(), "(")) {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else if (isOperator(val)) {
                while (!stack.isEmpty() && !Objects.equals(stack.peek(), "(") &&
                        precedence(val) <= precedence(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(val);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    static boolean isOperator(String c) {
        return Objects.equals(c, "+") ||
                Objects.equals(c, "-") ||
                Objects.equals(c, "/") ||
                Objects.equals(c, "*");
    }

    static int precedence(String c) {
        if (Objects.equals(c, "^")) {
            return 3;
        } else if (Objects.equals(c, "*") || Objects.equals(c, "/")) {
            return 2;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        String infix = "1+2*3";
        toPostfix(infix);
//        System.out.println();
    }

    int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        String[] parts = postfix.split("([+\\-*/()])");

        for (String s : parts) {
            if (!isOperator(s)) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                int val = eval(s, pop2, pop1);
                stack.push(val);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }

    int eval(String operator, int a, int b) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "/" -> a / b;
            default -> a * b;
        };
    }
}
