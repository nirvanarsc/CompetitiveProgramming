package binarysearch.weekly_40;

public class P_4 {

    public int solve(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        final int[][] dp = new int[n][m];
        dp[0] = matrix[0];
        for (int i = 1; i < n; i++) {
            final int[] r = new int[m];
            final int[] l = new int[m];
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
        int res = (int) -1e9;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, dp[n - 1][i]);
        }
        return res;
    }
}
