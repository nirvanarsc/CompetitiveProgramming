package leetcode.weekly_contests.weekly_300_399.weekly_345;

import java.util.Arrays;

public class P_3 {

    private static final int[][] DIRS = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

    public int maxMoves(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, (int) -1e9);
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (dp[i][j] != (int) -1e9) {
                    for (int[] dir : DIRS) {
                        final int ni = i + dir[0];
                        final int nj = j + dir[1];
                        if (0 <= ni && ni < n && 0 <= nj && nj < m && grid[i][j] < grid[ni][nj]) {
                            dp[ni][nj] = Math.max(dp[ni][nj], dp[i][j] + 1);
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
