package leetcode.weekly_contests.weekly_300_399.weekly_394;

import java.util.Arrays;

public class P_3 {

    public int minimumOperations(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] c = new int[m][10];
        for (int[] row : grid) {
            for (int j = 0; j < m; j++) {
                c[j][row[j]]++;
            }
        }
        final int[][] dp = new int[m + 1][10];
        for (int[] row : dp) {
            Arrays.fill(row, (int) 1e9);
        }
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (i == 0 || j != k) {
                        dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][k] + (n - c[i][j]));
                    }
                }
            }
        }
        int res = (int) 1e9;
        for (int i = 0; i < 10; i++) {
            res = Math.min(res, dp[m][i]);
        }
        return res;
    }
}
