package leetcode.weekly_contests.weekly_300_399;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int[] dp = new int[n + 1];
        int share = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            final int diff = (dp[Math.max(i - delay, 0)] - dp[Math.max(i - forget, 0)] + MOD) % MOD;
            dp[i] = share = (share + diff) % MOD;
        }
        int res = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            res = (res + dp[i]) % MOD;
        }
        return res;
    }
}
