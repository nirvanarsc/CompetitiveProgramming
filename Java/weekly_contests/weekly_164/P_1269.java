package weekly_contests.weekly_164;

public class P_1269 {

    private static final int MOD = (int) (1e9 + 7);

    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps);

        final int[][] dp = new int[steps + 1][arrLen];

        dp[1][0] = 1;
        dp[1][1] = 1;

        for (int step = 2; step <= steps; step++) {
            for (int pos = 0; pos < arrLen; pos++) {
                final int inPlace = dp[step - 1][pos];
                final int left = pos - 1 >= 0 ? dp[step - 1][pos - 1] : 0;
                final int right = pos + 1 < arrLen ? dp[step - 1][pos + 1] : 0;
                dp[step][pos] += left;
                dp[step][pos] %= MOD;
                dp[step][pos] += right;
                dp[step][pos] %= MOD;
                dp[step][pos] += inPlace;
                dp[step][pos] %= MOD;
            }
        }
        return dp[steps][0];
    }

    public int numWaysTopDown(int steps, int arrLen) {
        return recurse(0, steps, arrLen, new Integer[steps + 1][Math.min(steps, arrLen)]);
    }

    private static int recurse(int pos, int steps, int len, Integer[][] dp) {
        if (steps == 0 && pos == 0) {
            return 1;
        }
        if (pos < 0 || pos == len || steps == 0 || pos > steps) {
            return 0;
        }
        if (dp[steps][pos] != null) {
            return dp[steps][pos];
        }
        int res = 0;
        res += recurse(pos, steps - 1, len, dp);
        res %= MOD;
        res += recurse(pos - 1, steps - 1, len, dp);
        res %= MOD;
        res += recurse(pos + 1, steps - 1, len, dp);
        res %= MOD;
        return dp[steps][pos] = res;
    }
}
