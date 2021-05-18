package leetcode.weekly_contests.weekly_95;

import java.util.Arrays;

public class P_877 {

    static int[][] dp;

    public boolean stoneGame(int[] nums) {
        final int n = nums.length;
        if (n % 2 == 0) {
            return true;
        }
        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return 2 * dfs(nums, 0, n - 1) >= sum;
    }

    private static int dfs(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        int res = 0;
        res = Math.max(res, nums[start] - dfs(nums, start + 2, end));
        res = Math.max(res, nums[start] - dfs(nums, start + 1, end - 1));
        res = Math.max(res, nums[end] - dfs(nums, start + 1, end - 1));
        res = Math.max(res, nums[end] - dfs(nums, start, end - 2));
        return dp[start][end] = res;
    }

    public boolean stoneGameOld(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return 2 * recurse(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= sum;
    }

    private static int recurse(int[] nums, int start, int end, Integer[][] dp) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        return dp[start][end] = Math.max(nums[start] + Math.min(recurse(nums, start + 2, end, dp),
                                                                recurse(nums, start + 1, end - 1, dp)),
                                         nums[end] + Math.min(recurse(nums, start + 1, end - 1, dp),
                                                              recurse(nums, start, end - 2, dp)));
    }
}
