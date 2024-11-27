package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class P_3244 {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        final Map<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i < n - 1; ++i) {
            f.put(i, i + 1);
        }
        final int q = queries.length;
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final int u = queries[i][0];
            final int v = queries[i][1];
            if (f.getOrDefault(u, v) < v) {
                int curr = u;
                while (curr < v && f.containsKey(curr)) {
                    curr = f.remove(curr);
                }
                f.put(u, v);
            }
            res[i] = f.size();
        }
        return res;
    }
}
