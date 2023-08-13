package leetcode.weekly_contests.weekly_300_399.weekly_354;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_4 {

    public int longestValidSubstring(String word, List<String> forbidden) {
        final int n = word.length();
        final Set<String> set = new HashSet<>(forbidden);
        int res = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && isBad(word, set, j, i)) {
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    private static boolean isBad(String word, Set<String> set, int j, int i) {
        for (int k = Math.max(j, i - 10); k <= i; k++) {
            if (set.contains(word.substring(k, i + 1))) {
                return true;
            }
        }
        return false;
    }
}
