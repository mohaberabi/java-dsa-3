package Practice;

import java.util.Stack;

public class LongestValidParanthesis {


    static int longestValidPar(String s) {


        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();

                }
                if (!stack.isEmpty()) {
                    int curr = i - stack.peek();
                    res = Math.max(res, curr);
                } else {
                    stack.push(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(longestValidPar("((()"));
    }
}
