package Practice;

import java.util.Stack;

public class CountReversals {


    int countReversals(String s) {
        int res = 0;


        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    res++;
                    stack.push('{');
                }
            }
        }

        if (stack.size() % 2 != 0) {
            return -1;
        } else {
            res += (stack.size() / 2);
            return res;
        }
    }
}
