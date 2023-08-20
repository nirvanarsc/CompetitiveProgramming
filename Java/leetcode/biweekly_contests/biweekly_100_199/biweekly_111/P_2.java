package leetcode.biweekly_contests.biweekly_100_199.biweekly_111;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class P_2 {

    @SuppressWarnings("ReplaceNullCheck")
    public boolean canMakeSubsequence(String str1, String str2) {
        final Map<Integer, TreeSet<Integer>> g = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            g.computeIfAbsent(str1.charAt(i) - 'a', val -> new TreeSet<>()).add(i);
        }
        int curr = -1;
        int r = 0;
        while (r < str2.length()) {
            final int f = str2.charAt(r) - 'a';
            final int f2 = (f - 1 + 26) % 26;
            final Integer nextF = g.getOrDefault(f, new TreeSet<>()).higher(curr);
            final Integer nextF2 = g.getOrDefault(f2, new TreeSet<>()).higher(curr);
            if (nextF == null && nextF2 == null) {
                return false;
            }
            if (nextF != null && nextF2 != null) {
                curr = Math.min(nextF, nextF2);
            } else if (nextF != null) {
                curr = nextF;
            } else {
                curr = nextF2;
            }
            r++;
        }
        return true;
    }
}
