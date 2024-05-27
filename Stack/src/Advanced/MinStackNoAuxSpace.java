package Advanced;

import java.util.Stack;

public class MinStackNoAuxSpace {


    private int min = Integer.MAX_VALUE;

    private static final Stack<Integer> stack = new Stack<>();


    void push(int x) {


        if (stack.isEmpty()) {
            min = x;
            stack.push(x);
        } else if (x <= min) {
            stack.push(2 * x - min);
            min = x;
        } else {
            stack.push(x);
        }

    }


    int size() {
        return stack.size();
    }


    boolean isEmpty() {
        return stack.isEmpty();
    }

    int peek() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            int pek = stack.peek();
            if (pek <= min) {
                return min;
            } else {
                return pek;
            }
        }
    }

    int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int res;
        int pop = stack.pop();
        if (pop <= min) {
            res = min;
            min = 2 * min - pop;
            return res;
        } else {
            return pop;
        }

    }
}
