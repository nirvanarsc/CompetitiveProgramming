package leetcode.weekly_contests.weekly_100_199.weekly_130;

public class P_1020 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numEnclaves(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) { fill(grid, i, 0); }
            if (grid[i][m - 1] == 1) { fill(grid, i, m - 1); }
        }
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) { fill(grid, 0, i); }
            if (grid[n - 1][i] == 1) { fill(grid, n - 1, i); }
        }
        for (int[] row : grid) {
            for (int j = 0; j < m; j++) {
                res += row[j];
            }
        }
        return res;
    }

    private static void fill(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return;
        }
        grid[r][c] = 0;
        for (int[] dir : DIRS) {
            fill(grid, r + dir[0], c + dir[1]);
        }
    }
}
