package Practice;

import javax.swing.*;
import java.util.Stack;

public class ReduceStringConsecutiveByK {


    static class Pair {
        char c;
        int freq;


        public Pair(char c, int f) {
            this.c = c;
            freq = f;
        }


    }

    static String reduce(String word, int k) {

        if (k == 1) {
            return "";
        }
        Stack<Pair> stack = new Stack<>();
        for (char c : word.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(new Pair(c, 1));
            } else {

                if (stack.peek().c == c) {
                    Pair p = stack.pop();
                    p.freq += 1;
                    if (p.freq != k) {
                        stack.push(p);
                    }
                } else {
                    stack.push(new Pair(c, 1));
                }

            }
        }
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            int freq = pair.freq;
            char c = pair.c;

            while (freq-- > 0) {
                sb.append(c);
            }

        }

        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String word = "geegsforgeeeks";
        System.out.println(reduce(word, 2));
    }
}
