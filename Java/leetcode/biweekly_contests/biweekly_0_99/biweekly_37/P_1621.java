package leetcode.biweekly_contests.biweekly_0_99.biweekly_37;

public class P_1621 {

    private static final int MOD = (int) (1e9 + 7);

    public int numberOfSets(int n, int k) {
        final int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= k; ++j) {
            int sum = 0;
            for (int x = n - j; x < n; ++x) {
                sum += dp[x][j - 1];
                sum %= MOD;
            }
            for (int x = n - j - 1; x >= 0; --x) {
                dp[x][j] = (sum + dp[x + 1][j]) % MOD;
                sum += dp[x][j - 1];
                sum %= MOD;
            }
        }
        return dp[0][k];
    }
}
