package leetcode.weekly_contests.weekly_29;

public class P_562 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        final int n = M.length;
        final int m = M[0].length;
        final int[][][] dp = new int[n + 2][m + 2][4];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (M[i - 1][j - 1] == 1) {
                    dp[i][j][0] = dp[i - 1][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j + 1][1] + 1;
                    dp[i][j][2] = dp[i - 1][j][2] + 1;
                    dp[i][j][3] = dp[i][j - 1][3] + 1;
                }
                final int max1 = Math.max(dp[i][j][0], dp[i][j][1]);
                final int max2 = Math.max(dp[i][j][2], dp[i][j][3]);
                res = Math.max(res, Math.max(max1, max2));
            }
        }
        return res;
    }
}
