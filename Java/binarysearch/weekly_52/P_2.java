package binarysearch.weekly_52;

public class P_2 {

    private static final int[][] DIRS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int solve(int[][] a, int[][] b) {
        final int n = a.length;
        final int m = a[0].length;
        int res = 0;
        final int[][] f = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                f[i][j] = a[i][j] + b[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (f[i][j] == 1) {
                    dfs(f, i, j, n, m);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (f[i][j] == 2) {
                    res++;
                    dfs(f, i, j, n, m);
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] a, int i, int j, int n, int m) {
        if (a[i][j] == 0) {
            return;
        }
        a[i][j] = 0;
        for (int[] dir : DIRS) {
            final int nx = i + dir[0];
            final int ny = j + dir[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                dfs(a, nx, ny, n, m);
            }
        }
    }
}
