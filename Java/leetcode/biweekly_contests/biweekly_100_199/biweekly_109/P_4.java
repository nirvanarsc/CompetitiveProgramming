package leetcode.biweekly_contests.biweekly_100_199.biweekly_109;

public class P_4 {

    private static final int MOD = (int) 1e9 + 7;

    public int numberOfWays(int n, int x) {
        final int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int j = 1; j <= n; j++) {
            for (int i = n; i > 0; i--) {
                final int p = f(j, x);
                if (i >= p) {
                    dp[i] = (dp[i] + dp[i - p]) % MOD;
                }
            }
        }
        return dp[n];
    }

    private static int f(int n, int x) {
        long res = 1;
        for (int i = 0; i < x; i++) {
            res *= n;
        }
        res = Math.min(res, (int) 1e9);
        return (int) res;
    }
}
