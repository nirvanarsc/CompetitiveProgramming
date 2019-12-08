package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class P_890 {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        final List<String> res = new ArrayList<>();
        for (String w : words) {
            if (match(w, pattern)) {
                res.add(w);
            }
        }
        return res;
    }

    private static boolean match(String s, String p) {
        final Map<Character, Character> map1 = new HashMap<>();
        final Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            final char c1 = s.charAt(i);
            final char c2 = p.charAt(i);
            if (!map1.containsKey(c1)) {
                map1.put(c1, c2);
            }
            if (!map2.containsKey(c2)) {
                map2.put(c2, c1);
            }
            if (map1.get(c1) != c2 || map2.get(c2) != c1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                findAndReplacePattern(new String[] { "abc", "deq", "mee", "aqq", "dkd", "ccc" }, "abb"));
    }

    private P_890() {}
}
