package biweekly_contests.biweekly_13;

public class P_1259 {

    public int numberOfWays(int n) {
        n /= 2;
        final long[] dp = new long[n + 1];
        dp[0] = dp[1] = 1;

        final int mod = (int) (1e9 + 7);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = (dp[i] + dp[j - 1] * dp[i - j]) % mod;
            }
        }
        return (int) dp[n];
    }
}
