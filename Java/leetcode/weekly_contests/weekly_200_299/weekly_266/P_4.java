package leetcode.weekly_contests.weekly_200_299.weekly_266;

import java.util.ArrayList;
import java.util.List;

public class P_4 {

    static List<List<int[]>> g;
    static int[] seen;
    static int[] vals;
    static int res;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        final int n = values.length;
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            final int u = e[0];
            final int v = e[1];
            final int t = e[2];
            g.get(u).add(new int[] { v, t });
            g.get(v).add(new int[] { u, t });
        }
        seen = new int[n];
        vals = values;
        seen[0]++;
        res = 0;
        dfs(0, maxTime, values[0]);
        return res;
    }

    private static void dfs(int u, int maxTime, int curr) {
        if (u == 0) {
            res = Math.max(res, curr);
        }
        for (int[] next : g.get(u)) {
            final int v = next[0];
            final int t = next[1];
            if (maxTime - t < 0) {
                continue;
            }
            seen[v]++;
            dfs(v, maxTime - t, curr + (seen[v] == 1 ? vals[v] : 0));
            seen[v]--;
        }
    }
}
