package leetcode.weekly_contests.weekly_162;

public class P_1254 {

    public int closedIsland(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    fill(grid, i, j);
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    fill(grid, i, j);
                }
            }
        }
        return res;
    }

    private static void fill(int[][] grid, int row, int col) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] != 0) {
            return;
        }
        grid[row][col] = 1;
        for (int[] dir : new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }) {
            fill(grid, row + dir[0], col + dir[1]);
        }
    }
}
