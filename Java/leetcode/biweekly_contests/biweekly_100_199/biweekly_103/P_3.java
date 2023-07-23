package leetcode.biweekly_contests.biweekly_100_199.biweekly_103;

public class P_3 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int findMaxFish(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    res = Math.max(res, dfs(grid, i, j, n, m));
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] g, int i, int j, int n, int m) {
        int res = g[i][j];
        g[i][j] = 0;
        for (int[] dir : DIRS) {
            final int ni = i + dir[0];
            final int nj = j + dir[1];
            if (0 <= ni && ni < n && 0 <= nj && nj < m && g[ni][nj] > 0) {
                res += dfs(g, ni, nj, n, m);
            }
        }
        return res;
    }
}
