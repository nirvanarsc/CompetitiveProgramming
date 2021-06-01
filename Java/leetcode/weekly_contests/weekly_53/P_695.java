package leetcode.weekly_contests.weekly_53;

public class P_695 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        final int n = grid.length;
        final int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    final int[] temp = { 0 };
                    dfs(grid, i, j, n, m, temp);
                    res = Math.max(res, temp[0]);
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] g, int x, int y, int n, int m, int[] res) {
        res[0]++;
        g[x][y] = 0;
        for (int[] dir : DIRS) {
            final int nx = x + dir[0];
            final int ny = y + dir[1];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && g[nx][ny] == 1) {
                dfs(g, nx, ny, n, m, res);
            }
        }
    }
}
