package leetcode.weekly_contests.weekly_200_299.weekly_229;

import java.util.Arrays;

public class P_1771 {

    public int longestPalindrome(String word1, String word2) {
        final int n = word1.length();
        final int m = word2.length();
        final int[][][] dp = new int[n + m][n + m][2];
        for (int[][] row1 : dp) {
            for (int[] row2 : row1) {
                Arrays.fill(row2, -1);
            }
        }
        return dfs((word1 + word2).toCharArray(), 0, n + m - 1, 0, n, dp);
    }

    private static int dfs(char[] w, int i, int j, int flag, int n, int[][][] dp) {
        if (flag == 0 && (i == n || j == (n - 1))) {
            return 0;
        }
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return flag;
        }
        if (dp[i][j][flag] != -1) {
            return dp[i][j][flag];
        }
        int res = 0;
        if (w[i] == w[j]) {
            final int nf = flag == 1 ? 1 : (i < n && j >= n) ? 1 : 0;
            res = Math.max(res, 2 + dfs(w, i + 1, j - 1, nf, n, dp));
        }
        res = Math.max(res, dfs(w, i, j - 1, flag, n, dp));
        res = Math.max(res, dfs(w, i + 1, j, flag, n, dp));
        return dp[i][j][flag] = res;
    }
}
