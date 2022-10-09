package leetcode.weekly_contests.weekly_300_399.weekly_314;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    public int numberOfPaths(int[][] grid, int k) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][][] dp = new int[n][m][k];
        dp[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < k; l++) {
                    if (dp[i][j][l] == 0) {
                        continue;
                    }
                    if (i < n - 1) {
                        dp[i + 1][j][(l + grid[i][j]) % k] =
                                (dp[i + 1][j][(l + grid[i][j]) % k] + dp[i][j][l]) % MOD;
                    }
                    if (j < m - 1) {
                        dp[i][j + 1][(l + grid[i][j]) % k] =
                                (dp[i][j + 1][(l + grid[i][j]) % k] + dp[i][j][l]) % MOD;
                    }
                }
            }
        }
        return dp[n - 1][m - 1][(k - grid[n - 1][m - 1] % k) % k];
    }
}
