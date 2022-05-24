package leetcode.weekly_contests.weekly_100_199.weekly_111;

import java.util.Arrays;

public class P_943_dfs {

    static int n;
    static int[][] g;
    static int[][] dp;
    static String[] w;

    public String shortestSuperstring(String[] words) {
        w = words;
        n = words.length;
        g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = getCost(words[i], words[j]);
                g[j][i] = getCost(words[j], words[i]);
            }
        }
        dp = new int[n][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dfs(0, 0);
        return getString(0, 0);
    }

    private static int getCost(String a, String b) {
        for (int i = 1; i < a.length(); i++) {
            if (b.startsWith(a.substring(i))) {
                return b.length() - a.length() + i;
            }
        }
        return b.length();
    }

    private static String getString(int u, int mask) {
        if (mask == (1 << n) - 1) {
            return "";
        }
        int best = (int) 1e9;
        int bestIdx = -1;
        for (int v = 0; v < n; v++) {
            if ((mask & (1 << v)) == 0) {
                final int cost = mask == 0 ? w[v].length() : g[u][v];
                if (best > cost + dp[v][mask | (1 << v)]) {
                    best = cost + dp[v][mask | (1 << v)];
                    bestIdx = v;
                }
            }
        }
        final String curr = mask == 0 ? w[bestIdx] : w[bestIdx].substring(w[bestIdx].length() - g[u][bestIdx]);
        return curr + getString(bestIdx, mask | (1 << bestIdx));
    }

    private static int dfs(int u, int mask) {
        if (mask == (1 << n) - 1) {
            return 0;
        }
        if (dp[u][mask] != -1) {
            return dp[u][mask];
        }
        int res = (int) 1e9;
        for (int v = 0; v < n; v++) {
            if ((mask & (1 << v)) == 0) {
                final int cost = mask == 0 ? w[v].length() : g[u][v];
                res = Math.min(res, cost + dfs(v, mask | (1 << v)));
            }
        }
        return dp[u][mask] = res;
    }
}
