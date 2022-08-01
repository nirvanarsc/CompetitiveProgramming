package leetcode.weekly_contests.weekly_300_399.weekly_304;

import java.util.HashMap;
import java.util.Map;

public class P_4 {

    public int longestCycle(int[] edges) {
        final int n = edges.length;
        int res = -1;
        final boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (seen[i]) {
                continue;
            }
            final Map<Integer, Integer> d = new HashMap<>();
            for (int u = i, dist = 0; u != -1; u = edges[u]) {
                if (d.containsKey(u)) {
                    res = Math.max(res, dist - d.get(u));
                    break;
                }
                if (seen[u]) {
                    break;
                }
                seen[u] = true;
                d.put(u, dist++);
            }
        }
        return res;
    }
}
