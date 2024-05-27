package Advanced;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanProblem {


    ArrayList<Integer> stockSpan(int[] arr) {

        ArrayList<Integer> res = new ArrayList<>();


        Stack<Integer> stack = new Stack<>();

        res.add(1);

        stack.push(0);


        int n = arr.length;
        for (int i = 1; i < n; i++) {

            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }

            int span = stack.isEmpty() ? i + 1 : i - stack.peek();
            res.add(span);
            stack.push(i);

        }
        return res;
    }
}
