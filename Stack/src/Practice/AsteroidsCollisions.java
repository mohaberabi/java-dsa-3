package Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AsteroidsCollisions {


    static int[] asterioidsCollisons(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();


        Queue<Integer> q = new LinkedList<>();
        for (int x : asteroids) {
            if (stack.isEmpty() || x > 0) {
                stack.push(x);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0) {
                    int right = stack.pop();
                    q.add(right);

                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = q.poll();
        }

        return result;

    }

    public static void main(String[] args) {
        int[] as = {3, 5, -3};
        int[] res = asterioidsCollisons(as);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }

}
