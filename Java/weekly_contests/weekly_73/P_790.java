package weekly_contests.weekly_73;

public class P_790 {

    private static final int MOD = (int) (1e9 + 7);

    @SuppressWarnings("MethodParameterNamingConvention")
    public int numTilings(int N) {
        if (N < 3) {
            return N;
        }
        final int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = ((2 * dp[i - 1]) % MOD + dp[i - 3]) % MOD;
        }
        return dp[N];
    }
}
