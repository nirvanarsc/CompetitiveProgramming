package leetcode.weekly_contests.weekly_200_299.weekly_257;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        final int n = nextVisit.length;
        final long[] dp = new long[n];
        for (int i = 1; i < n; i++) {
            dp[i] = (2 + 2 * dp[i - 1] - dp[nextVisit[i - 1]] + MOD) % MOD;
        }
        return (int) dp[n - 1];
    }

}
