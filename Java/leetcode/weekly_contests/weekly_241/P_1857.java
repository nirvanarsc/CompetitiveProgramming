package leetcode.weekly_contests.weekly_241;

import java.util.Arrays;

public class P_1857 {

    private static final int MOD = (int) (1e9 + 7);

    static long[][] dp;

    public int rearrangeSticks(int n, int k) {
        dp = new long[n][n + 1];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return (int) dfs(n, 0, k);
    }

    private static long dfs(int n, int idx, int k) {
        if (idx == n) {
            return k == 0 ? 1 : 0;
        }
        if (dp[idx][k] != -1) {
            return dp[idx][k];
        }
        long res = 0;
        if (k > 0) {
            res = (res + dfs(n, idx + 1, k - 1)) % MOD;
        }
        final long add = (n - idx - 1) * dfs(n, idx + 1, k) % MOD;
        res = (res + add) % MOD;
        return dp[idx][k] = res;
    }
}
