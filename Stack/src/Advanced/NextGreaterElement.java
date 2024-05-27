package Advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {
    ArrayList<Integer> stockSpan(int[] arr) {

        ArrayList<Integer> res = new ArrayList<>();


        Stack<Integer> stack = new Stack<>();

        res.add(-1);
        int n = arr.length;

        stack.push(n - 1);


        for (int i = n - 2; i >= 0; i--) {

            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }

            int great = stack.isEmpty() ? -1 : arr[stack.peek()];
            res.add(great);
            stack.push(i);

        }

        Collections.reverse(res);
        return res;
    }

}
