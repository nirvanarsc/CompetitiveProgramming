package leetcode.weekly_contests.weekly_200_299.weekly_289;

public class P_3 {

    public int maxTrailingZeros(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] r2 = fRow(n, m, grid, 2);
        final int[][] r5 = fRow(n, m, grid, 5);
        final int[][] c2 = fCol(n, m, grid, 2);
        final int[][] c5 = fCol(n, m, grid, 5);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int copy = grid[i][j];
                int f2 = 0;
                int f5 = 0;
                while (copy % 2 == 0) {
                    f2++;
                    copy /= 2;
                }
                while (copy % 5 == 0) {
                    f5++;
                    copy /= 5;
                }
                res = Math.max(res, Math.min(r2[i][j + 1] + c2[i + 1][j] - f2,
                                             r5[i][j + 1] + c5[i + 1][j] - f5));
                res = Math.max(res, Math.min(r2[i][m] - r2[i][j] + c2[i + 1][j] - f2,
                                             r5[i][m] - r5[i][j] + c5[i + 1][j] - f5));
                res = Math.max(res, Math.min(r2[i][j + 1] + c2[n][j] - c2[i][j] - f2,
                                             r5[i][j + 1] + c5[n][j] - c5[i][j] - f5));
                res = Math.max(res, Math.min(r2[i][m] - r2[i][j] + c2[n][j] - c2[i][j] - f2,
                                             r5[i][m] - r5[i][j] + c5[n][j] - c5[i][j] - f5));
            }
        }
        return res;
    }

    private static int[][] fRow(int n, int m, int[][] g, int f) {
        final int[][] res = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                int c = 0;
                int copy = g[i][j - 1];
                while (copy % f == 0) {
                    c++;
                    copy /= f;
                }
                res[i][j] = res[i][j - 1] + c;
            }
        }
        return res;
    }

    private static int[][] fCol(int n, int m, int[][] g, int f) {
        final int[][] res = new int[n + 1][m];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                int c = 0;
                int copy = g[i - 1][j];
                while (copy % f == 0) {
                    c++;
                    copy /= f;
                }
                res[i][j] = res[i - 1][j] + c;
            }
        }
        return res;
    }
}
