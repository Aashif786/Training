package INTERVIEWQUESTIONS;

import java.util.*;

public class sherlock {
    public static String isValid(String s) {
        int[] frequency = new int[26];
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int count : frequency) {
            if (count > 0) {
                freqCount.put(count, freqCount.getOrDefault(count, 0) + 1);
            }
        }

        if (freqCount.size() == 1) {
            return "YES";
        } else if (freqCount.size() == 2) {
            List<Integer> keys = new ArrayList<>(freqCount.keySet());
            int key1 = keys.get(0);
            int key2 = keys.get(1);
            if ((freqCount.get(key1) == 1 && (key1 - 1 == key2 || key1 == 1)) ||
                    (freqCount.get(key2) == 1 && (key2 - 1 == key1 || key2 == 1))) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        String s = "aabbcd"; // Example input
        System.out.println(isValid(s));

    }
}
