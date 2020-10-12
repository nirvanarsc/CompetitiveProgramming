package leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("TailRecursion")
public class P_291 {

    Set<String> set;
    Map<Character, String> map;

    public boolean wordPatternMatch(String pattern, String str) {
        set = new HashSet<>();
        map = new HashMap<>();
        return dfs(pattern, str, 0, 0);
    }

    private boolean dfs(String p, String t, int i, int j) {
        if (i == p.length() && j == t.length()) {
            return true;
        }
        if (i == p.length() || j == t.length()) {
            return false;
        }
        final char curr = p.charAt(i);
        if (map.containsKey(curr)) {
            final String key = map.get(curr);
            if (!t.startsWith(key, j)) {
                return false;
            }
            return dfs(p, t, i + 1, j + key.length());
        }
        for (int k = j + 1; k <= t.length(); k++) {
            final String hash = t.substring(j, k);
            if (!set.contains(hash)) {
                set.add(hash);
                map.put(curr, hash);
                if (dfs(p, t, i + 1, k)) {
                    return true;
                }
                set.remove(hash);
                map.remove(curr);
            }
        }
        return false;
    }
}
