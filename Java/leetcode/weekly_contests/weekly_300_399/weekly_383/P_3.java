package leetcode.weekly_contests.weekly_300_399.weekly_383;

public class P_3 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] resultGrid(int[][] image, int threshold) {
        final int n = image.length;
        final int m = image[0].length;
        final int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curr = 0;
                int count = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        final int add = f(image, i - k, j - l, n, m, threshold);
                        if (add != -1) {
                            curr += add;
                            count++;
                        }
                    }
                }
                res[i][j] = count == 0 ? image[i][j] : curr / count;
            }
        }
        return res;
    }

    private static int f(int[][] g, int r, int c, int n, int m, int threshold) {
        if (!(0 <= r && r < n && 0 <= c && c < m)) {
            return -1;
        }
        if (!(0 <= r + 2 && (r + 2) < n && 0 <= c + 2 && (c + 2) < m)) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int u = r + i;
                final int v = c + j;
                for (int[] dir : DIRS) {
                    final int nu = u + dir[0];
                    final int nv = v + dir[1];
                    if (r <= nu && nu <= r + 2 && c <= nv && nv <= c + 2) {
                        if (Math.abs(g[u][v] - g[nu][nv]) > threshold) {
                            return -1;
                        }
                    }
                }
                res += g[u][v];
            }
        }
        return res / 9;
    }
}
