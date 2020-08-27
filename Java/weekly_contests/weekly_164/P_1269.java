package weekly_contests.weekly_164;

public class P_1269 {

    private static final int MOD = (int) (1e9 + 7);

    public int numWays(int steps, int arrLen) {
        final int n = Math.min(arrLen, steps);
        final int[][] dp = new int[steps + 1][n];
        dp[0][0] = 1;
        for (int step = 1; step <= steps; step++) {
            for (int pos = 0; pos < Math.min(n, 2 * step); pos++) {
                final int inPlace = dp[step - 1][pos];
                final int left = pos - 1 >= 0 ? dp[step - 1][pos - 1] : 0;
                final int right = pos + 1 < n ? dp[step - 1][pos + 1] : 0;
                dp[step][pos] = (dp[step][pos] + left) % MOD;
                dp[step][pos] = (dp[step][pos] + right) % MOD;
                dp[step][pos] = (dp[step][pos] + inPlace) % MOD;
            }
        }
        return dp[steps][0];
    }

    public int numWaysTopDown(int steps, int arrLen) {
        final int n = Math.min(steps, arrLen);
        return dfs(0, steps, n, new Integer[steps + 1][n]);
    }

    private static int dfs(int idx, int steps, int n, Integer[][] dp) {
        if (steps == 0) {
            return idx == 0 ? 1 : 0;
        }
        if (idx < 0 || idx == n || idx > steps) {
            return 0;
        }
        if (dp[steps][idx] != null) {
            return dp[steps][idx];
        }
        int res = 0;
        res = (res + dfs(idx, steps - 1, n, dp)) % MOD;
        res = (res + dfs(idx - 1, steps - 1, n, dp)) % MOD;
        res = (res + dfs(idx + 1, steps - 1, n, dp)) % MOD;
        return dp[steps][idx] = res;
    }
}
