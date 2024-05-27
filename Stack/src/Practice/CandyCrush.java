package Practice;

import java.util.Stack;

public class CandyCrush {


    static String candyCrush(String word) {
        Stack<Character> stack = new Stack<>();


        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }


        while (!stack.isEmpty()) {

            boolean skip = false;
            char pop = stack.pop();

            while (!stack.isEmpty() && stack.peek() == pop) {
                stack.pop();
                skip = true;
            }

            if (!skip) {
                StringBuilder temp = new StringBuilder();
                temp.append(pop);
                temp.append(sb);
                sb = temp;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String word = "geegsforgeeeks";
        System.out.println(candyCrush(word));
    }
}
