package leetcode.weekly_contests.weekly_100_199.weekly_108;

public class P_931 {

    public int minFallingPathSum(int[][] grid) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] += i > 0 ? getMin(i, j, grid) : 0;
                if (i == grid.length - 1) {
                    res = Math.min(res, grid[i][j]);
                }
            }
        }
        return res;
    }

    private static int getMin(int i, int j, int[][] grid) {
        int res = Integer.MAX_VALUE;
        for (int t : new int[] { -1, 0, 1 }) {
            if (t + j >= 0 && t + j < grid[0].length) {
                res = Math.min(res, grid[i - 1][t + j]);
            }
        }
        return res;
    }

    public int minFallingPathSumDP(int[][] grid) {
        return dfs(grid, 0, -1, grid[0].length, new Integer[grid.length][grid[0].length]);
    }

    private static int dfs(int[][] grid, int row, int col, int m, Integer[][] dp) {
        if (row == grid.length) {
            return 0;
        }
        if (col >= 0 && dp[row][col] != null) {
            return dp[row][col];
        }
        int res = (int) 1e9;
        if (col == -1) {
            for (int i = 0; i < m; i++) {
                res = Math.min(res, grid[row][i] + dfs(grid, row + 1, i, m, dp));
            }
        } else {
            if (col > 0) {
                res = Math.min(res, grid[row][col - 1] + dfs(grid, row + 1, col - 1, m, dp));
            }
            res = Math.min(res, grid[row][col] + dfs(grid, row + 1, col, m, dp));
            if (col < m - 1) {
                res = Math.min(res, grid[row][col + 1] + dfs(grid, row + 1, col + 1, m, dp));
            }
        }
        if (col >= 0) {
            dp[row][col] = res;
        }
        return res;
    }
}
