package Advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LArgestRectangulerAreaInAHistoGram {


    static int largestArea(int[] arr) {
        int n = arr.length;


        int res = 0;

        for (int i = 0; i < n; i++) {

            int curr = arr[i];


            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] >= arr[i]) {
                    curr += arr[i];
                } else {
                    break;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (arr[j] >= arr[i]) {
                    curr += arr[i];
                } else {
                    break;
                }
            }
            res = Math.max(res, curr);
        }
        return res;
    }


    static int largestAreaUsingStack(int[] arr) {
        int n = arr.length;


        Stack<Integer> stack = new Stack<>();


        ArrayList<Integer> previousSmaller = new ArrayList<>();
        ArrayList<Integer> nextSmaller = new ArrayList<>();

        previousSmaller.add(-1);
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }

            int sml = stack.isEmpty() ? -1 : stack.peek();
            previousSmaller.add(sml);
            stack.push(i);

        }

        stack.clear();
        stack.push(n - 1);
        nextSmaller.add(n);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            int sml = stack.isEmpty() ? n : stack.peek();
            nextSmaller.add(sml);
            stack.push(i);

        }


        Collections.reverse(nextSmaller);


        int res = 0;

        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            curr += (i - previousSmaller.get(i) - 1) * arr[i];
            curr += (nextSmaller.get(i) - i - 1) * arr[i];

            res = Math.max(res, curr);
        }


        return res;
    }


    static int largestAreaUsingStackOptimal(int[] arr) {


        Stack<Integer> stack = new Stack<>();
        int res = 0;

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int pop = stack.pop();

                curr = arr[pop] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                res = Math.max(res, curr);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            int curr = arr[pop] * (stack.isEmpty() ? n : (n - stack.peek() - 1));
            res = Math.max(res, curr);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        int res = largestAreaUsingStackOptimal(arr);
        System.out.println(res);
    }
}
