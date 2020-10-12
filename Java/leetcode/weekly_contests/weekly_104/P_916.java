package leetcode.weekly_contests.weekly_104;

import java.util.ArrayList;
import java.util.List;

public class P_916 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public List<String> wordSubsets(String[] A, String[] B) {
        final List<String> res = new ArrayList<>();
        final int[] max = new int[26];
        for (String b : B) {
            final int[] map = count(b);
            for (int i = 0; i < 26; i++) {
                max[i] = Math.max(max[i], map[i]);
            }
        }
        for (String w : A) {
            final int[] map = count(w);
            int i;
            for (i = 0; i < 26; i++) {
                if (map[i] < max[i]) { break; }
            }
            if (i == 26) { res.add(w); }
        }
        return res;
    }

    private static int[] count(String w) {
        final int[] map = new int[26];
        for (char c : w.toCharArray()) {
            map[c - 'a']++;
        }
        return map;
    }
}
