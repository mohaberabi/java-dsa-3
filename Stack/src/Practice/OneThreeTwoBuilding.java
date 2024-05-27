package Practice;

import java.util.Stack;

public class OneThreeTwoBuilding {


    boolean isOneThreeTwoBuilding(int[] arr) {
        int n = arr.length;


        Stack<Integer> stack = new Stack<>();


        int[] previousMin = new int[n];

        previousMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            previousMin[i] = Math.min(arr[i], previousMin[i - 1]);
        }


        for (int i = n - 1; i >= 0; i--) {

            if (arr[i] > previousMin[i]) {
                while (!stack.isEmpty() && stack.peek() <= previousMin[i]) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() < arr[i]) {
                    return true;
                }

                stack.push(arr[i]);

            }
        }


        return false;
    }
}
