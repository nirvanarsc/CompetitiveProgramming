package leetcode.weekly_contests.weekly_0_99.weekly_73;

public class P_790 {

    private static final int MOD = (int) (1e9 + 7);

    static int[] dp;
    static boolean init;

    public int numTilings(int n) {
        if (!init) {
            dp = new int[(int) (1e3 + 5)];
            dp[0] = dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < dp.length; i++) {
                dp[i] = ((2 * dp[i - 1]) % MOD + dp[i - 3]) % MOD;
            }
            init = true;
        }
        return dp[n];
    }
}
