package Practice.FirstNonRepeatingCharInStream;

import java.util.ArrayList;
import java.util.HashMap;

public class UsingHashing {


    String firstNonRepeatingCharacterUsingHashing(String s) {

        ArrayList<Character> al = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
                al.add(c);
            } else {
                int index = al.indexOf(c);
                if (index != -1) {
                    al.remove(index);
                }
            }

            sb.append(al.isEmpty() ? "#" : al.get(0));
        }

        return sb.toString();

    }
}
