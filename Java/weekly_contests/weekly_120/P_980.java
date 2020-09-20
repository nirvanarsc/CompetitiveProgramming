package weekly_contests.weekly_120;

public class P_980 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int uniquePathsIII(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[] res = { 0 };
        final int[] empty = { 1 };
        int sx = 0, sy = 0, ex = 0, ey = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 0) {
                    empty[0]++;
                } else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }
            }
        }
        dfs(grid, sx, sy, ex, ey, empty, res);
        return res[0];
    }

    public void dfs(int[][] grid, int x, int y, int ex, int ey, int[] empty, int[] res) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) {
            return;
        }
        if (x == ex && y == ey) {
            if (empty[0] == 0) {
                res[0]++;
            }
            return;
        }
        empty[0]--;
        grid[x][y] = -1;
        for (int[] dir : DIRS) {
            dfs(grid, x + dir[0], y + dir[1], ex, ey, empty, res);
        }
        grid[x][y] = 0;
        empty[0]++;
    }
}
