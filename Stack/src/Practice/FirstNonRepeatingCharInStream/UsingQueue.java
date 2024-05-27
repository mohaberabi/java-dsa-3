package Practice.FirstNonRepeatingCharInStream;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class UsingQueue {


    String firstNonRepeatnigCharacter(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        String res = "";


        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                q.add(c);
            }

            map.put(c, map.getOrDefault(c, 0) + 1);


            while (!q.isEmpty() && map.get(q.peek()) > 1) {
                q.poll();
            }

            if (q.isEmpty()) {
                res += "#";
            } else {
                res += q.peek();
            }
        }
        return res;


    }
}
