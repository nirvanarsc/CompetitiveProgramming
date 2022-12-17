package leetcode.weekly_contests.weekly_300_399.weekly_322;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_4 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] cc;
    static int[] colors;

    public int magnificentSets(int m, int[][] e) {
        n = m;
        final int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = (int) 1e9;
            }
        }
        for (int[] ee : e) {
            final int u = --ee[0];
            final int v = --ee[1];
            dp[u][v] = dp[v][u] = 1;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        edges = e;
        g = packG();
        cc = new int[n];
        colors = new int[n];
        Arrays.fill(cc, -1);
        Arrays.fill(colors, -1);
        int res = 0;
        int component = 0;
        for (int i = 0; i < n; i++) {
            if (cc[i] == -1) {
                if (!dfs(i, 0, component)) {
                    return -1;
                }
                final List<Integer> curr = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (cc[j] == component) {
                        curr.add(j);
                    }
                }
                int v = 0;
                for (int j : curr) {
                    for (int k : curr) {
                        if (j != k) {
                            v = Math.max(v, dp[j][k]);
                        }
                    }
                }
                res += v + 1;
                component++;
            }
        }
        return res;
    }

    private static boolean dfs(int u, int color, int component) {
        colors[u] = color;
        cc[u] = component;
        for (int v : g[u]) {
            if (cc[v] == -1) {
                if (!dfs(v, 1 ^ color, component)) {
                    return false;
                }
            } else {
                if (colors[v] != (1 ^ color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
            g[edge[1]][--size[edge[1]]] = edge[0];
        }
        return g;
    }
}
