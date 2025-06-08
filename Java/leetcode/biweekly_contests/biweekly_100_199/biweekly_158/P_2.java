package leetcode.biweekly_contests.biweekly_100_199.biweekly_158;

public class P_2 {

    public long maximumProfit(int[] prices, int k) {
        final int n = prices.length;
        final long[][][] dp = new long[n + 1][k + 1][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = (long) -1e13;
                dp[i][j][1] = (long) -1e13;
                dp[i][j][2] = (long) -1e13;
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l < 3; l++) {
                    if (dp[i][j][l] == (long) -1e13) {
                        continue;
                    }
                    dp[i + 1][j][l] = Math.max(dp[i + 1][j][l], dp[i][j][l]);
                    if (l == 0 && j != k) {
                        dp[i + 1][j + 1][1] = Math.max(dp[i + 1][j + 1][1], dp[i][j][0] + prices[i]);
                        dp[i + 1][j + 1][2] = Math.max(dp[i + 1][j + 1][2], dp[i][j][0] - prices[i]);
                    } else if (l == 1) {
                        dp[i + 1][j][0] = Math.max(dp[i + 1][j][0], dp[i][j][1] - prices[i]);
                    } else if (l == 2) {
                        dp[i + 1][j][0] = Math.max(dp[i + 1][j][0], dp[i][j][2] + prices[i]);
                    }
                }
            }
        }
        long res = 0;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, dp[n][i][0]);
        }
        return res;
    }
}
