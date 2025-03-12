package INTERVIEWQUESTIONS;

import java.util.*;

public class anagramcount {

    public static void main(String[] args) {
        String s = "forxxorfxdoffr";
        String pat = "for";
        Map<Character, Integer> m = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (m.containsKey(c)) {
                m.put(c, m.get(c) + 1);
            } else {
                m.put(c, 1);
            }
        }
        int count = Integer.MAX_VALUE;
        for (char c : pat.toCharArray()) {
            count = Math.min(count, m.get(c));
        }

        System.out.println(count);
    }
}