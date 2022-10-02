package leetcode.weekly_contests.weekly_300_399.weekly_313;

public class P_2 {

    public int maxSum(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                res = Math.max(res, f(grid, i, j));
            }
        }
        return res;
    }

    private static int f(int[][] g, int i, int j) {
        int res = -g[i + 1][j] - g[i + 1][j + 2];
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                res += g[i + k][j + l];
            }
        }
        return res;
    }
}
