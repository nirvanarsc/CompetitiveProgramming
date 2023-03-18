package leetcode.biweekly_contests.biweekly_0_99.biweekly_91;

public class P_2 {

    private static final int MOD = (int) (1e9 + 7);

    public int countGoodStrings(int low, int high, int zero, int one) {
        final int[] dp = new int[high + 1];
        dp[0] = 1;
        final int[] f = { zero, one };
        for (int i = 0; i < high; i++) {
            for (int u : f) {
                if (u + i <= high) {
                    dp[u + i] = (dp[u + i] + dp[i]) % MOD;
                }
            }
        }
        int res = 0;
        for (int i = low; i <= high; i++) {
            res = (res + dp[i]) % MOD;
        }
        return res;
    }
}
