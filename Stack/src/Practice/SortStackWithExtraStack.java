package Practice;

import java.util.Stack;

public class SortStackWithExtraStack {


    Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> temp = new Stack<>();
        while (!input.isEmpty()) {
            int pop = input.pop();
            while (!temp.isEmpty() && pop > temp.peek()) {
                input.push(temp.pop());
            }
            temp.push(pop);
        }
        return temp;
    }
}
