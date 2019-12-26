package easy;

import java.util.Arrays;

public class P_198 {

    public int rob(int[] nums) {
        final int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return recurse(0, nums, dp);
    }

    private static int recurse(int start, int[] nums, int[] dp) {
        if (start >= nums.length) {
            return 0;
        }

        if (dp[start] != 0) {
            return dp[start];
        }

        return dp[start] = Math.max(nums[start] + recurse(start + 2, nums, dp), recurse(start + 1, nums, dp));
    }
}
