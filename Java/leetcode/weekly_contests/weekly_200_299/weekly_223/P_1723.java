package leetcode.weekly_contests.weekly_200_299.weekly_223;

import java.util.Arrays;

public class P_1723 {

    public int minimumTimeRequired(int[] jobs, int k) {
        final int n = jobs.length;
        final int[] masks = new int[1 << n];
        for (int mask = 0; mask < 1 << n; mask++) {
            int cost = 0;
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    cost += jobs[j];
                }
            }
            masks[mask] = cost;
        }
        final int[][] dp = new int[1 << n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(masks, (1 << n) - 1, k, dp);
    }

    private static int dfs(int[] masks, int mask, int k, int[][] dp) {
        if (k == 0) {
            return mask == 0 ? 0 : (int) 1e9;
        }
        if (dp[mask][k] != -1) {
            return dp[mask][k];
        }
        int res = (int) 1e9;
        for (int subMask = mask; subMask > 0; subMask = (subMask - 1) & mask) {
            res = Math.min(res, Math.max(masks[subMask], dfs(masks, mask ^ subMask, k - 1, dp)));
        }
        return dp[mask][k] = res;
    }
}
