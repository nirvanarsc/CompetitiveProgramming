package leetcode.weekly_contests.weekly_300_399.weekly_350;

import java.util.Arrays;

public class P_4 {

    public int paintWalls(int[] cost, int[] time) {
        final int n = cost.length;
        final int[] dp = new int[n + 1];
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = n; j > 0; --j) {
                dp[j] = Math.min(dp[j], dp[Math.max(j - time[i] - 1, 0)] + cost[i]);
            }
        }
        return dp[n];
    }
}
