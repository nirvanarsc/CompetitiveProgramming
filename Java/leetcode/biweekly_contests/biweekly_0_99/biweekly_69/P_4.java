package leetcode.biweekly_contests.biweekly_0_99.biweekly_69;

public class P_4 {

    private static int[][] pref2d(int[][] g, int n, int m) {
        final int[][] res = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i + 1][j + 1] = g[i][j] + res[i + 1][j] + res[i][j + 1] - res[i][j];
            }
        }
        return res;
    }

    private static int sum2d(int[][] p, int c1, int r1, int c2, int r2) {
        return p[c2 + 1][r2 + 1] + p[c1][r1] - p[c1][r2 + 1] - p[c2 + 1][r1];
    }

    public boolean possibleToStamp(int[][] grid, int h, int w) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] stamp = new int[n][m];
        final int[][] p = pref2d(grid, n, m);
        for (int i = h - 1; i < n; i++) {
            for (int j = w - 1; j < m; j++) {
                stamp[i][j] = sum2d(p, i - h + 1, j - w + 1, i, j) == 0 ? 1 : 0;
            }
        }
        final int[][] p2 = pref2d(stamp, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0
                    && sum2d(p2, i, j, Math.min(n - 1, i + h - 1), Math.min(m - 1, j + w - 1)) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
