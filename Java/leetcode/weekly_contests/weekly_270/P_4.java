package leetcode.weekly_contests.weekly_270;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

    static Map<Integer, List<Integer>> g;
    static int[] rev;
    static int[] in;
    static int[] out;
    static int[][] res;
    static int rIdx;

    public int[][] validArrangement(int[][] pairs) {
        final int n = pairs.length;
        final Map<Integer, Integer> idx = new HashMap<>(2 * n);
        int m = 0;
        for (int[] pair : pairs) {
            final int u = pair[0];
            final int v = pair[1];
            Integer prev = idx.get(u);
            if (prev == null) {
                idx.put(u, m++);
            }
            prev = idx.get(v);
            if (prev == null) {
                idx.put(v, m++);
            }
        }
        g = new HashMap<>(m);
        in = new int[m];
        out = new int[m];
        rev = new int[m];
        for (int[] edge : pairs) {
            final int u = idx.get(edge[0]);
            final int v = idx.get(edge[1]);
            rev[u] = edge[0];
            rev[v] = edge[1];
            out[u]++;
            in[v]++;
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
        }
        res = new int[n][2];
        rIdx = n - 1;
        int start = 0;
        for (int i = 0; i < m; i++) {
            if (out[i] - in[i] == 1) {
                start = i;
            }
        }
        dfs(start);
        return res;
    }

    private static void dfs(int u) {
        while (out[u] > 0) {
            final int v = g.get(u).get(--out[u]);
            dfs(v);
            res[rIdx--] = new int[] { rev[u], rev[v] };
        }
    }
}
