package leetcode.weekly_contests.weekly_300_399.weekly_305;

public class P_3 {

    public boolean validPartition(int[] nums) {
        final int n = nums.length;
        final int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (i < (n - 1)) {
                if (nums[i] == nums[i + 1]) {
                    dp[i + 2] = Math.max(dp[i + 2], dp[i]);
                }
            }
            if (i < (n - 2)) {
                if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2] ||
                    nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2]) {
                    dp[i + 3] = Math.max(dp[i + 3], dp[i]);
                }
            }
        }
        return dp[n] == 1;
    }
}
