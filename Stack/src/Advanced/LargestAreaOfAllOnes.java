package Advanced;

import java.util.ArrayList;
import java.util.Stack;

public class LargestAreaOfAllOnes {


    int largestAreaOfHistoGram(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();


        int res = 0;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                int pop = stack.pop();

                curr = arr[pop] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                res = Math.max(curr, res);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();

            int curr = arr[pop] * (stack.isEmpty() ? n : n - stack.peek() - 1);
            res = Math.max(curr, res);


        }
        return res;

    }

    int maxRectangleOfAllOnes(int[][] arr) {
        int n = arr.length;

        int largest = largestAreaOfHistoGram(arr[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] == 1) {
                    arr[i][j] += arr[i - 1][j];
                }
            }
            largest = Math.max(largest, largestAreaOfHistoGram(arr[i]));
        }
        return largest;
    }


}
