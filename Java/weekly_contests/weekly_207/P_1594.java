package weekly_contests.weekly_207;

public class P_1594 {

    private static final int MOD = (int) (1e9 + 7);

    public int maxProductPath(int[][] grid) {
        final long res = dfs(grid, 0, 0, new Long[grid.length][grid[0].length][2])[0];
        return res < 0 ? -1 : (int) (res % MOD);
    }

    private static Long[] dfs(int[][] grid, int i, int j, Long[][][] dp) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return new Long[] { (long) grid[i][j], (long) grid[i][j] };
        }
        if (dp[i][j][0] != null && dp[i][j][1] != null) {
            return dp[i][j];
        }
        long max = (long) -1e18;
        long min = (long) 1e18;
        if (i < grid.length - 1) {
            final Long[] down = dfs(grid, i + 1, j, dp);
            if (grid[i][j] < 0) {
                max = Math.max(max, grid[i][j] * down[1]);
                min = Math.min(min, grid[i][j] * down[0]);
            } else {
                max = Math.max(max, grid[i][j] * down[0]);
                min = Math.min(min, grid[i][j] * down[1]);
            }
        }
        if (j < grid[0].length - 1) {
            final Long[] right = dfs(grid, i, j + 1, dp);
            if (grid[i][j] < 0) {
                max = Math.max(max, grid[i][j] * right[1]);
                min = Math.min(min, grid[i][j] * right[0]);
            } else {
                max = Math.max(max, grid[i][j] * right[0]);
                min = Math.min(min, grid[i][j] * right[1]);
            }
        }
        return dp[i][j] = new Long[] { max, min };
    }
}
