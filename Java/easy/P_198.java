package easy;

public class P_198 {

    public int rob(int[] nums) {
        return recurse(0, nums, new Integer[nums.length]);
    }

    private static int recurse(int start, int[] nums, Integer[] dp) {
        if (start >= nums.length) {
            return 0;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        return dp[start] = Math.max(nums[start] + recurse(start + 2, nums, dp), recurse(start + 1, nums, dp));
    }
}
