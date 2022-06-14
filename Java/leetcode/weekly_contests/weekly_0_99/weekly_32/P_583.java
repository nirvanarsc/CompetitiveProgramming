package leetcode.weekly_contests.weekly_0_99.weekly_32;

public class P_583 {

    public int minDistance(String word1, String word2) {
        final int n = word1.length();
        final int m = word2.length();
        return n + m - 2 * lcs(word1, word2, n, m);
    }

    private static int lcs(String word1, String word2, int n, int m) {
        final char[] l = word1.toCharArray();
        final char[] r = word2.toCharArray();
        final int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (l[i] == r[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
