package leetcode.weekly_contests.weekly_400_499.weekly_430;

public class P_1 {

    public int minimumOperations(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        int res = 0;
        for (int c = 0; c < m; c++) {
            int u = grid[0][c];
            for (int r = 1; r < n; r++) {
                res += Math.max(0, u - grid[r][c] + 1);
                u = Math.max(u + 1, grid[r][c]);
            }
        }
        return res;
    }
}
