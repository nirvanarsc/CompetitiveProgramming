package weekly_contests.weekly_95;

public class P_877 {

    public boolean stoneGame(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return 2 * recurse(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= sum;
    }

    private static int recurse(int[] nums, int start, int end, Integer[][] dp) {
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        return dp[start][end] = Math.max(nums[start] + Math.min(recurse(nums, start + 2, end, dp),
                                                                recurse(nums, start + 1, end - 1, dp)),
                                         nums[end] + Math.min(recurse(nums, start + 1, end - 1, dp),
                                                              recurse(nums, start, end - 2, dp)));
    }
}
