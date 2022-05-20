package leetcode.medium;

public final class P_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int n = obstacleGrid.length;
        final int m = obstacleGrid[0].length;
        final int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i + 1][j] += dp[i][j];
                    dp[i][j + 1] += dp[i][j];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
