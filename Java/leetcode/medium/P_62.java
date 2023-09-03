package leetcode.medium;

public class P_62 {

    public int uniquePaths(int n, int m) {
        final int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j] += dp[i][j];
                dp[i][j + 1] += dp[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }
}
