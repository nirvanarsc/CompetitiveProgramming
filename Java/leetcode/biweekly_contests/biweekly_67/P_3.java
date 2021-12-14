package leetcode.biweekly_contests.biweekly_67;

import java.util.ArrayList;
import java.util.List;

public class P_3 {

    static List<List<Integer>> g;
    static boolean[] seen;
    static int curr;

    public int maximumDetonation(int[][] bombs) {
        final int n = bombs.length;
        g = new ArrayList<>(n);
        seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (i == j) { continue; }
                final int dx = Math.abs(bombs[i][0] - bombs[j][0]);
                final int dy = Math.abs(bombs[i][1] - bombs[j][1]);
                final long ll = (long) bombs[i][2] * bombs[i][2];
                final long rr = (long) dx * dx + (long) dy * dy;
                if (ll >= rr) {
                    g.get(i).add(j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            curr = 0;
            seen = new boolean[n];
            dfs(i);
            res = Math.max(res, curr);
        }
        return res;
    }

    private static void dfs(int u) {
        if (seen[u]) {
            return;
        }
        curr++;
        seen[u] = true;
        for (int v : g.get(u)) {
            dfs(v);
        }
    }
}
