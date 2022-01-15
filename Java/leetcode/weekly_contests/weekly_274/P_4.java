package leetcode.weekly_contests.weekly_274;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_4 {

    static int[] zz;
    static List<List<Integer>> g;

    public int maximumInvitations(int[] favorite) {
        final int n = favorite.length;
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            g.get(favorite[i]).add(i);
        }
        zz = new int[n];
        Arrays.fill(zz, -1);
        for (int i = 0; i < n; i++) {
            dfs(i, i);
        }
        int[] f = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(zz[i] >= 0) {
                f[zz[i]]++;
                res = Math.max(res, f[zz[i]]);
            }
        }
        return res;
    }

    private static void dfs(int u, int v) {
        if (zz[u] >= 0) {
            return;
        }
        zz[u] = v;
        for (int next : g.get(u)) {
            dfs(next, v);
        }
    }
}
