package leetcode.medium;

public class P_198 {

    public int rob(int[] nums) {
        final int n = nums.length;
        final int[] dp = new int[n + 2];
        for (int i = 0; i <= n; i++) {
            if (i < n) {
                dp[i + 2] = Math.max(dp[i + 2], dp[i] + nums[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        return dp[n + 1];
    }
}
