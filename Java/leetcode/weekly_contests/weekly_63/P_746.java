package leetcode.weekly_contests.weekly_63;

import java.util.Arrays;

public class P_746 {

    static int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private static int dfs(int[] arr, int idx) {
        if (idx >= arr.length) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int res = (int) 1e9;
        res = Math.min(res, arr[idx] + dfs(arr, idx + 1));
        res = Math.min(res, arr[idx] + dfs(arr, idx + 2));
        return dp[idx] = res;
    }
}
