package binarysearch.weekly_48;

import java.util.Arrays;

public class P_4 {

    static int[][] dp;
    private static final int MOD = (int) (1e9 + 7);

    public int solve(int n, int k) {
        dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(n, k);
    }

    private static int dfs(int n, int k) {
        if (n < 0) {
            return 0;
        }
        if (k == 0) {
            return n == 0 ? 1 : 0;
        }
        if (dp[n][k] != -1) {
            return dp[n][k];
        }
        int res = dfs(n - 1, k - 1);
        if (n >= k) {
            res = (res + dfs(n - k, k)) % MOD;
        }
        return dp[n][k] = res;
    }
}
