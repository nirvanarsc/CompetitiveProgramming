package leetcode.weekly_contests.weekly_98;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P_890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        return Arrays.stream(words)
                     .filter(w -> match(w, pattern))
                     .collect(Collectors.toList());
    }

    private static boolean match(String w, String p) {
        final Map<Character, Character> map1 = new HashMap<>();
        final Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < w.length(); i++) {
            if (map1.getOrDefault(p.charAt(i), w.charAt(i)) != w.charAt(i)) {
                return false;
            }
            if (map2.getOrDefault(w.charAt(i), p.charAt(i)) != p.charAt(i)) {
                return false;
            }
            map1.put(p.charAt(i), w.charAt(i));
            map2.put(w.charAt(i), p.charAt(i));
        }
        return true;
    }
}
