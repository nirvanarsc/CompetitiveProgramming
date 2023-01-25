package leetcode.weekly_contests.weekly_300_399.weekly_329;

import java.util.Arrays;

public class P_4 {

    public int minCost(int[] nums, int k) {
        final int n = nums.length;
        final int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            final int[] f = new int[n];
            int c = 0;
            for (int j = i; j < n; j++) {
                final int u = ++f[nums[j]];
                if (u == 2) {
                    c += 2;
                } else if (u > 2) {
                    c += 1;
                }
                g[i][j] = c;
            }
        }
        final int[] dp = new int[n + 1];
        Arrays.fill(dp, (int) 2e9);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[j + 1] = Math.min(dp[j + 1], dp[i] + k + g[i][j]);
            }
        }
        return dp[n];
    }
}
