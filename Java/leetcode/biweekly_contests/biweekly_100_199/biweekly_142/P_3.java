package leetcode.biweekly_contests.biweekly_100_199.biweekly_142;

public class P_3 {

    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        final int[][] dp = new int[k + 1][n];
        for (int i = 0; i < k; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    dp[i + 1][v] = Math.max(dp[i + 1][v], dp[i][u] + travelScore[u][v]);
                }
                dp[i + 1][u] = Math.max(dp[i + 1][u], dp[i][u] + stayScore[i][u]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[k][i]);
        }
        return res;
    }
}
