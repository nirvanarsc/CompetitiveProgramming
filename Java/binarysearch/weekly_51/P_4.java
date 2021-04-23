package binarysearch.weekly_51;

import java.util.Arrays;

public class P_4 {

    static int[][][] dp;

    public int solve(int n, int k) {
        dp = new int[n + 1][n + 1][1 << n];
        for (int[][] r1 : dp) {
            for (int[] r2 : r1) {
                Arrays.fill(r2, -1);
            }
        }
        return dfs((1 << n) - 1, 0, 0, n, k);
    }

    private static int dfs(int mask, int max, int curr, int n, int k) {
        if (mask == 0) {
            return curr == k ? 1 : 0;
        }
        if (dp[max][curr][mask] != -1) {
            return dp[max][curr][mask];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                if ((i + 1) < max) {
                    res += dfs(mask ^ (1 << i), max, curr, n, k);
                } else {
                    res += dfs(mask ^ (1 << i), i + 1, curr + 1, n, k);
                }
            }
        }
        return dp[max][curr][mask] = res;
    }
}
