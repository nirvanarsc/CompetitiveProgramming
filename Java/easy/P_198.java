package easy;

public class P_198 {

    public int rob(int[] nums) {
        return dfs(nums, 0, new Integer[nums.length]);
    }

    private static int dfs(int[] nums, int idx, Integer[] dp) {
        if (idx >= nums.length) {
            return 0;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        return dp[idx] = Math.max(dfs(nums, idx + 1, dp), nums[idx] + dfs(nums, idx + 2, dp));
    }
}
