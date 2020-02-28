package weekly_contests.weekly_134;

public class P_1034 {
    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private static void dfs(int[][] g, int r, int c, int original) {
        if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] != original) {
            return;
        }
        g[r][c] = -original;

        for (int[] dir : DIRS) {
            dfs(g, r + dir[0], c + dir[1], original);
        }
        if (r > 0 && r < g.length - 1 && c > 0 && c < g[0].length - 1) {
            boolean res = true;
            for (int[] dir : DIRS) {
                res &= original == Math.abs(g[r + dir[0]][c + dir[1]]);
            }
            if (res) {
                g[r][c] = original;
            }
        }
    }

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        dfs(grid, r0, c0, grid[r0][c0]);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = grid[i][j] < 0 ? color : grid[i][j];
            }
        }
        return grid;
    }
}
