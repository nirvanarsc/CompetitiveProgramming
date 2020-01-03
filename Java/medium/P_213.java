package medium;

public class P_213 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int from, int to) {
        return recurse(from, to, nums, new Integer[nums.length]);
    }

    private static int recurse(int start, int to, int[] nums, Integer[] dp) {
        if (start >= to) {
            return 0;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        return dp[start] = Math.max(nums[start] + recurse(start + 2, to, nums, dp),
                                    recurse(start + 1, to, nums, dp));
    }
}
