package leetcode.weekly_contests.weekly_0_99.weekly_63;

import java.util.Arrays;

public class P_746 {

    static int[] dp;
    static boolean[] seen;
    static int n;

    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        dp = new int[n];
        seen = new boolean[n];
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private static int dfs(int[] arr, int idx) {
        if (idx >= n) {
            return 0;
        }
        if (seen[idx]) {
            return dp[idx];
        }
        int res = (int) 1e9;
        res = Math.min(res, arr[idx] + dfs(arr, idx + 1));
        res = Math.min(res, arr[idx] + dfs(arr, idx + 2));
        seen[idx] = true;
        return dp[idx] = res;
    }
}
