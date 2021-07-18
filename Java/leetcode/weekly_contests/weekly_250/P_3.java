package leetcode.weekly_contests.weekly_250;

public class P_3 {

    public long maxPoints(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        final long[][] dp = new long[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            final long[] r = new long[m];
            final long[] l = new long[m];
            for (int j = m - 1; j >= 0; j--) {
                if (j == m - 1) {
                    r[j] = dp[i - 1][j] - j;
                } else {
                    r[j] = Math.max(r[j + 1], dp[i - 1][j] - j);
                }
            }
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    l[0] = dp[i - 1][0];
                } else {
                    l[j] = Math.max(l[j - 1], dp[i - 1][j] + j);
                }
            }
            for (int j = 0; j < m; j++) {
                dp[i][j] = matrix[i][j] + Math.max(r[j] + j, l[j] - j);
            }
        }
        long res = (long) -1e18;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, dp[n - 1][i]);
        }
        return res;
    }
}
