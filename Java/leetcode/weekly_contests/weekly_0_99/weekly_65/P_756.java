package leetcode.weekly_contests.weekly_0_99.weekly_65;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_756 {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        final Map<String, Set<Character>> m = new HashMap<>();
        for (String s : allowed) {
            m.computeIfAbsent(s.substring(0, 2), v -> new HashSet<>()).add(s.charAt(2));
        }
        return dfs(bottom, "", m, 1);
    }

    @SuppressWarnings("TailRecursion")
    private static boolean dfs(String row, String nextRow, Map<String, Set<Character>> allowed, int i) {
        if (row.length() == 1) {
            return true;
        }
        if (nextRow.length() + 1 == row.length()) {
            return dfs(nextRow, "", allowed, 1);
        }
        for (Character c : allowed.getOrDefault(row.substring(i - 1, i + 1), Collections.emptySet())) {
            if (dfs(row, nextRow + c, allowed, i + 1)) {
                return true;
            }
        }
        return false;
    }
}
