package leetcode.biweekly_contests.biweekly_100_199.biweekly_117;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int stringCount(int n) {
        final long[][] dp = new long[n + 1][1 << 4];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int mask = 0; mask < 1 << 4; mask++) {
                dp[i + 1][mask | 1] = (dp[i + 1][mask | 1] + dp[i][mask]) % MOD;
                if ((mask & 2) == 0) {
                    dp[i + 1][mask | 2] = (dp[i + 1][mask | 2] + dp[i][mask]) % MOD;
                } else {
                    dp[i + 1][mask | 4] = (dp[i + 1][mask | 4] + dp[i][mask]) % MOD;
                }
                dp[i + 1][mask | 8] = (dp[i + 1][mask | 8] + dp[i][mask]) % MOD;
                dp[i + 1][mask] = (dp[i + 1][mask] + 23 * dp[i][mask]) % MOD;
            }
        }
        return (int) dp[n][15];
    }
}
