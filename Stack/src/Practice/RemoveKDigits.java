package Practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveKDigits {


    static String removeKDigits(String s, int k) {

        if (k == 0) {
            return s;
        }
        int n = s.length();

        if (k > n) {
            return "0";
        }


        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                k--;
                stack.pop();
            }

            if (!stack.isEmpty() || c != '0') {
                stack.push(c);
            }


        }
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;

        }

        if (stack.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("1002991", 3));
    }
}
