package Advanced;

import java.util.ArrayList;
import java.util.Stack;

public class PreviousGreaterElement {
    ArrayList<Integer> previousGreaterElement(int[] arr) {

        ArrayList<Integer> res = new ArrayList<>();


        Stack<Integer> stack = new Stack<>();

        res.add(-1);

        stack.push(0);


        int n = arr.length;
        for (int i = 1; i < n; i++) {

            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }

            int great = stack.isEmpty() ? -1 : arr[stack.peek()];
            res.add(great);
            stack.push(i);
        }
        return res;
    }
}
