package leetcode.weekly_contests.weekly_12;

import java.util.Arrays;

public class P_474 {

    public int findMaxForm(String[] strs, int m, int n) {
        final int[][] f = new int[strs.length][2];
        final int[][][] dp = new int[strs.length][m + 1][n + 1];
        for (int[][] row1 : dp) {
            for (int[] row2 : row1) {
                Arrays.fill(row2, -1);
            }
        }
        for (int i = 0; i < strs.length; i++) {
            final String s = strs[i];
            for (char c : s.toCharArray()) {
                f[i][c - '0']++;
            }
        }
        return dfs(f, 0, m, n, dp);
    }

    private static int dfs(int[][] f, int idx, int m, int n, int[][][] dp) {
        if (idx == f.length) {
            return 0;
        }
        if (dp[idx][m][n] != -1) {
            return dp[idx][m][n];
        }
        int res = dfs(f, idx + 1, m, n, dp);
        if (f[idx][0] <= m && f[idx][1] <= n) {
            res = Math.max(res, 1 + dfs(f, idx + 1, m - f[idx][0], n - f[idx][1], dp));
        }
        return dp[idx][m][n] = res;
    }
}
