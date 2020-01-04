package medium;

public class P_494 {

    public int findTargetSumWays(int[] nums, int S) {
        return recurse(nums, 0, 0, S, new Integer[nums.length][2001]);
    }

    private static int recurse(int[] nums, int start, int curr, int S, Integer[][] dp) {
        if (start == nums.length) {
            if (curr == S) {
                return 1;
            }
            return 0;
        }

        if (dp[start][curr + 1000] != null) {
            return dp[start][curr + 1000];
        }

        final int add = recurse(nums, start + 1, curr - nums[start], S, dp);
        final int sub = recurse(nums, start + 1, curr + nums[start], S, dp);
        return dp[start][curr + 1000] = add + sub;
    }
}
