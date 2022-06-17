package leetcode.weekly_contests.weekly_200_299.weekly_297;

import java.util.HashMap;
import java.util.Map;

public class P_4 {

    public long distinctNames(String[] ideas) {
        final Map<String, Integer> group = new HashMap<>();
        final int[] f = new int[26];
        final int[][] g = new int[26][26];
        for (String w : ideas) {
            final int u = w.charAt(0) - 'a';
            w = w.substring(1);
            final int mask = group.getOrDefault(w, 0);
            group.put(w, mask | 1 << u);
            f[u]++;
            for (var j = 0; j < 26; j++) {
                if ((mask & (1 << j)) != 0) {
                    ++g[u][j];
                    ++g[j][u];
                }
            }
        }
        long res = 0L;
        for (int i = 1; i < 26; i++) {
            for (int j = 0; j < i; j++) {
                res += (long) (f[i] - g[i][j]) * (f[j] - g[i][j]);
            }
        }
        return res * 2;
    }
}
