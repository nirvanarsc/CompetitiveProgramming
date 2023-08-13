package leetcode.weekly_contests.weekly_300_399.weekly_353;

import java.util.Arrays;

public class P_2 {

    public int maximumJumps(int[] nums, int target) {
        final int n = nums.length;
        final int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] != -1) {
                for (int j = i + 1; j < n; j++) {
                    if (-target <= (nums[j] - nums[i]) && (nums[j] - nums[i]) <= target) {
                        dp[j] = Math.max(dp[j], dp[i] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
