package leetcode.medium;

public class P_198 {

    static int[] dp;
    static boolean[] seen;

    public int rob(int[] nums) {
        final int n = nums.length;
        dp = new int[n];
        seen = new boolean[n];
        return dfs(nums, 0);
    }

    private static int dfs(int[] nums, int idx) {
        if (idx >= nums.length) {
            return 0;
        }
        if (seen[idx]) {
            return dp[idx];
        }
        seen[idx] = true;
        return dp[idx] = Math.max(dfs(nums, idx + 1), nums[idx] + dfs(nums, idx + 2));
    }
}
