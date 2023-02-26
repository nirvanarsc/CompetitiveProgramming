package leetcode.hard;

import java.util.Arrays;

public class P_72 {

    public int minDistance(String word1, String word2) {
        final int n = word1.length();
        final int m = word2.length();
        final char[] l = word1.toCharArray();
        final char[] r = word2.toCharArray();
        final int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, (int) 1e9);
        }
        for (int i = 0; i <= n; i++) { dp[i][0] = i; }
        for (int i = 0; i <= m; i++) { dp[0][i] = i; }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], (l[i] != r[j] ? 1 : 0) + dp[i][j]);
                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], 1 + dp[i][j + 1]);
                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], 1 + dp[i + 1][j]);
            }
        }
        return dp[n][m];
    }
}
