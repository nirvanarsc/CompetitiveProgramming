package leetcode.weekly_contests.weekly_0_99.weekly_99;

public class P_892 {

    public int surfaceArea(int[][] grid) {
        int res = 0;
        final int n = grid.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) { res += grid[i][j] * 4 + 2; }
                if (i > 0) { res -= Math.min(grid[i][j], grid[i - 1][j]) * 2; }
                if (j > 0) { res -= Math.min(grid[i][j], grid[i][j - 1]) * 2; }
            }
        }
        return res;
    }
}
