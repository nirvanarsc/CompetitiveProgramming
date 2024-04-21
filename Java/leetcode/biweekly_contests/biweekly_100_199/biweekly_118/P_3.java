package leetcode.biweekly_contests.biweekly_100_199.biweekly_118;

import java.util.Arrays;

public class P_3 {

    public int minimumCoins(int[] prices) {
        final int n = prices.length;
        final int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, (int) 1e9);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][i + 1] = Math.min(dp[i + 1][i + 1], dp[i][j] + prices[i]);
                if (j > 0) {
                    dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j]);
                }
            }
        }
        int res = (int) 1e9;
        for (int i = 0; i <= n; i++) {
            res = Math.min(res, dp[n][i]);
        }
        return res;
    }
}
