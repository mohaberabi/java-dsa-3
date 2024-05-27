package Advanced;

import java.util.Stack;

public class MinStack {


    public static final Stack<Integer> stack = new Stack<>();
    public static final Stack<Integer> minStack = new Stack<>();


    public MinStack() {
    }


    void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            minStack.push(x);
        } else {
            stack.push(x);
            if (minStack.peek() >= stack.peek()) {
                minStack.push(x);
            }
        }
    }


    int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

    int pop() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            int pop = stack.pop();
            if (pop == minStack.peek()) {
                minStack.pop();
            }
            return pop;
        }
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(Integer.MIN_VALUE);
        minStack.push(0);
        minStack.push(1);
        minStack.push(2);
        minStack.push(213213);
        int min = minStack.getMin();
        minStack.pop();

        System.out.println(min);
        min = minStack.getMin();
        System.out.println(min);
    }
}
