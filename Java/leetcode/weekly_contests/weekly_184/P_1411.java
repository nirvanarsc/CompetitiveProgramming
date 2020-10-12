package leetcode.weekly_contests.weekly_184;

public class P_1411 {

    private static final int MOD = (int) (1e9 + 7);

    public int numOfWays(int n) {
        final long[] dp = new long[n + 1];
        dp[0] = 3;
        dp[1] = 12;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.floorMod(5 * dp[i - 1] - 2 * dp[i - 2], MOD);

        }
        return (int) dp[n];
    }
}
