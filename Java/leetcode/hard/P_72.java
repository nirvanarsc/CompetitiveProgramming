package leetcode.hard;

import java.util.Arrays;

public class P_72 {

    public int minDistanceTopDown(String word1, String word2) {
        final int n = word1.length();
        final int m = word2.length();
        final int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, (int) 1e9);
        }
        for (int i = 0; i <= n; i++) { dp[i][0] = i; }
        for (int i = 0; i <= m; i++) { dp[0][i] = i; }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    static boolean[][] seen;
    static int[][] dp;

    public int minDistance(String word1, String word2) {
        final int n = word1.length();
        final int m = word2.length();
        seen = new boolean[n][m];
        dp = new int[n][m];
        return dfs(word1.toCharArray(), word2.toCharArray(), 0, 0);
    }

    private static int dfs(char[] l, char[] r, int i, int j) {
        if (i == l.length) {
            return r.length - j;
        }
        if (j == r.length) {
            return l.length - i;
        }
        if (seen[i][j]) {
            return dp[i][j];
        }
        int res = (int) 1e9;
        if (l[i] == r[j]) {
            res = dfs(l, r, i + 1, j + 1);
        } else {
            res = Math.min(res, 1 + dfs(l, r, i + 1, j + 1));
            res = Math.min(res, 1 + dfs(l, r, i + 1, j));
            res = Math.min(res, 1 + dfs(l, r, i, j + 1));
        }
        seen[i][j] = true;
        return dp[i][j] = res;
    }
}
