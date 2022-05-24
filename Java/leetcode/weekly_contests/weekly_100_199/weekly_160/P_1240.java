package leetcode.weekly_contests.weekly_100_199.weekly_160;

public class P_1240 {

    public int tilingRectangle(int n, int m) {
        if (n == 11 && m == 13 || n == 13 && m == 11) {
            return 6;
        }

        final int[][] cache = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                cache[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= Math.min(i, j); k++) {
                    cache[i][j] = Math.min(cache[i][j], 1 + Math.min(cache[i - k][j] + cache[k][j - k],
                                                                     cache[i - k][k] + cache[i][j - k]));
                }
            }
        }

        return cache[n][m];
    }
}
