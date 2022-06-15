package leetcode.weekly_contests.weekly_200_299.weekly_297;

import java.util.Arrays;

public class P_2 {

    public int minPathCost(int[][] grid, int[][] moveCost) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] dp = new int[n][m];
        for (int i = 1; i < n; i++) {
            Arrays.fill(dp[i], (int) 1e9);
        }
        dp[0] = grid[0];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    dp[i + 1][k] = Math.min(dp[i + 1][k], dp[i][j] + moveCost[grid[i][j]][k] + grid[i + 1][k]);
                }
            }
        }
        int res = (int) 1e9;
        for (int i = 0; i < m; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}
