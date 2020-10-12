package leetcode.biweekly_contests.biweekly_27;

public class P_1463 {

    private static final int[][] DIRS = {
            { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }
    };

    public int cherryPickup(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        return dfs(grid, 0, 0, m - 1, new Integer[n][m][m]);
    }

    private static int dfs(int[][] grid, int level, int r1, int r2, Integer[][][] dp) {
        if (level == grid.length) {
            return 0;
        }
        if (dp[level][r1][r2] != null) {
            return dp[level][r1][r2];
        }
        final int cherry = r1 == r2 ? grid[level][r1] : grid[level][r1] + grid[level][r2];
        int max = 0;
        for (int[] dir : DIRS) {
            final int nextR1 = r1 + dir[0];
            final int nextR2 = r2 + dir[1];
            if (nextR1 >= 0 && nextR1 < grid[0].length && nextR2 >= 0 && nextR2 < grid[0].length) {
                max = Math.max(max, dfs(grid, level + 1, nextR1, nextR2, dp));
            }
        }
        return dp[level][r1][r2] = cherry + max;
    }
}
