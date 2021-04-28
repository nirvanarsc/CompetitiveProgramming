package leetcode.medium;

import java.util.Arrays;

public final class P_63 {

    public static int uniquePathsWithObstaclesBottomUp(int[][] obstacleGrid) {
        final int m = obstacleGrid[0].length;
        final int[] dp = new int[m];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < m; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[m - 1];
    }

    private static int[][] dp;
    private static int n;
    private static int m;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        n = obstacleGrid.length;
        m = obstacleGrid[0].length;
        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(obstacleGrid, 0, 0);
    }

    private static int dfs(int[][] g, int r, int c) {
        if (g[r][c] == 1) {
            return 0;
        }
        if (r == n - 1 && c == m - 1) {
            return 1;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        int res = 0;
        if ((r + 1) < n) {
            res += dfs(g, r + 1, c);
        }
        if ((c + 1) < m) {
            res += dfs(g, r, c + 1);
        }
        return dp[r][c] = res;
    }
}
