package Practice;

import java.util.Stack;

public class SortStackDecreasingOrder {


    void sortStackDecreasingOrder(Stack<Integer> stack) {

        sortUtil(stack);

    }


    void sortUtil(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int temp = stack.pop();

        sortUtil(stack);
        insertInSortedStack(stack, temp);
    }


    void insertInSortedStack(Stack<Integer> s, int x) {
        if (s.isEmpty() || s.peek() <= x) {
            s.push(x);
        } else {
            int pop = s.pop();
            insertInSortedStack(s, x);
            s.push(pop);
        }

    }
}
