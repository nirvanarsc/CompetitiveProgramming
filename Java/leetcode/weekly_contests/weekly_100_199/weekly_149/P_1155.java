package leetcode.weekly_contests.weekly_100_199.weekly_149;

public class P_1155 {

    private static final int MOD = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        if (n * k < target) {
            return 0;
        }
        final int[][] dp = new int[n + 1][target + k + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (dp[i][j] == 0) {
                    continue;
                }
                for (int u = 1; u <= k; u++) {
                    dp[i + 1][j + u] = (dp[i + 1][j + u] + dp[i][j]) % MOD;
                }
            }
        }
        return dp[n][target];
    }
}
