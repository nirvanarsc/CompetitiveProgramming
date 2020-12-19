package leetcode.biweekly_contests.biweekly_27;

public class P_1463 {

    private static final int[] DIRS = { -1, 0, 1 };

    public int cherryPickup(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        return dfs(grid, 0, 0, m - 1, new Integer[n][m][m]);
    }

    private static int dfs(int[][] grid, int row, int r1, int r2, Integer[][][] dp) {
        if (row == grid.length) {
            return 0;
        }
        if (dp[row][r1][r2] != null) {
            return dp[row][r1][r2];
        }
        int curr = grid[row][r1] + grid[row][r2];
        if (r1 == r2) {
            curr -= grid[row][r1];
        }
        int res = 0;
        for (int d1 : DIRS) {
            for (int d2 : DIRS) {
                final int nr1 = r1 + d1;
                final int nr2 = r2 + d2;
                if (nr1 >= 0 && nr1 < grid[0].length && nr2 >= 0 && nr2 < grid[0].length) {
                    res = Math.max(res, curr + dfs(grid, row + 1, nr1, nr2, dp));
                }
            }
        }
        return dp[row][r1][r2] = res;
    }
}
