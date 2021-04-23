package binarysearch.weekly_52;

import java.util.Arrays;

public class P_3 {

    static int[][] dp;
    static char[] w;
    static int n;

    public int solve(String s) {
        dp = new int[s.length()][26];
        w = s.toCharArray();
        n = w.length;
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (w[i] == 'a' || w[i] == '?') {
                res = Math.max(res, dfs(i, 0));
            }
        }
        return res;
    }

    private static int dfs(int i, int j) {
        if (i == n || j == 26) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int res = w[i] == '?' ? dfs(i + 1, j) : 0;
        if (w[i] == '?' || w[i] - 'a' == j) {
            res = Math.max(res, 1 + dfs(i + 1, j + 1));
        }
        return dp[i][j] = res;
    }
}
