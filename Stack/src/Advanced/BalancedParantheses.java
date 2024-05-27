package Advanced;

import java.util.Stack;

public class BalancedParantheses {
    static boolean ispar(String x) {
        Stack<Character> s = new Stack<>();

        for (char c : x.toCharArray()) {
            if (isOpen(c)) {
                s.push(c);
            } else if (s.isEmpty() || !isBalanced(s.pop(), c)) {
                return false;
            }
        }
        return s.isEmpty();

        // add your code here
    }

    static boolean isOpen(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    static boolean isBalanced(char a, char b) {
        return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
    }
}
