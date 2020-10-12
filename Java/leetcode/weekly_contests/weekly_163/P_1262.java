package leetcode.weekly_contests.weekly_163;

import java.util.Arrays;

public class P_1262 {

    public static int maxSumDivK(int[] nums, int k) {
        int[] dp = new int[k];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int num : nums) {
            final int[] curr = new int[k];
            for (int i = 0; i < k; i++) {
                curr[(i + num) % k] = Math.max(dp[(i + num) % k], dp[i] + num);
            }
            dp = curr;
        }

        return dp[0];
    }

    public static int maxSumDivThreeBottomUp(int[] nums) {
        return maxSumDivK(nums, 3);
    }

    public int maxSumDivThree(int[] nums) {
        return recurse(0, nums, 0, new Integer[nums.length][3]);
    }

    private static int recurse(int start, int[] nums, int remainder, Integer[][] dp) {
        if (start == nums.length) {
            return 0;
        }
        if (dp[start][remainder] != null) {
            return dp[start][remainder];
        }
        int ans = 0;
        final int skip = recurse(start + 1, nums, remainder, dp);
        if ((remainder + skip) % 3 == 0) {
            ans = skip;
        }
        final int add = recurse(start + 1, nums, (remainder + nums[start]) % 3, dp);
        if ((remainder + nums[start] + add) % 3 == 0) {
            ans = Math.max(ans, nums[start] + add);
        }
        return dp[start][remainder] = ans;
    }
}
