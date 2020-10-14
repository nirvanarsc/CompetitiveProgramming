package leetcode.medium;

public class P_213 {

    public int rob(int[] nums) {
        final int n = nums.length;
        final Integer[][] dp = new Integer[n][2];
        return Math.max(nums[0] + dfs(nums, 2, 0, dp), dfs(nums, 1, 1, dp));
    }

    private static int dfs(int[] nums, int idx, int end, Integer[][] dp) {
        if (idx >= nums.length) {
            return 0;
        }
        if (idx == nums.length - 1) {
            return end == 1 ? nums[idx] : 0;
        }
        if (dp[idx][end] != null) {
            return dp[idx][end];
        }
        return dp[idx][end] = Math.max(nums[idx] + dfs(nums, idx + 2, end, dp), dfs(nums, idx + 1, end, dp));
    }
}
