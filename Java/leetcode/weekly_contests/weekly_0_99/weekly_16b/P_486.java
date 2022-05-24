package leetcode.weekly_contests.weekly_0_99.weekly_16b;

import java.util.Arrays;

public class P_486 {

    public boolean PredictTheWinner(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        final int sum = Arrays.stream(nums).sum();
        return 2 * dfs(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= sum;
    }

    private static int dfs(int[] nums, int start, int end, Integer[][] dp) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }

        final int takeS = nums[start] + Math.min(dfs(nums, start + 2, end, dp),
                                                 dfs(nums, start + 1, end - 1, dp));
        final int takeE = nums[end] + Math.min(dfs(nums, start + 1, end - 1, dp),
                                               dfs(nums, start, end - 2, dp));

        return dp[start][end] = Math.max(takeS, takeE);
    }
}
