package leetcode.weekly_contests.weekly_100_199.weekly_183;

import java.util.Arrays;

public class P_1406 {

    public String stoneGameIIIBottomUp(int[] stoneValue) {
        final int n = stoneValue.length;
        final int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = Integer.MIN_VALUE;
            for (int k = 0, take = 0; k < 3 && i + k < n; ++k) {
                take += stoneValue[i + k];
                dp[i] = Math.max(dp[i], take - dp[i + k + 1]);
            }
        }
        return dp[0] == 0 ? "Tie"
                          : dp[0] > 0 ? "Alice" : "Bob";
    }

    public String stoneGameIII(int[] stoneValue) {
        final int sum = Arrays.stream(stoneValue).sum();
        final int res = 2 * recurse(stoneValue, 0, new Integer[stoneValue.length]);
        return res == sum ? "Tie"
                          : res > sum ? "Alice" : "Bob";
    }

    private static int recurse(int[] nums, int start, Integer[] dp) {
        if (start >= nums.length) {
            return 0;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        int res = Integer.MIN_VALUE;
        for (int k = 0, sum = 0; k < 3 && start + k < nums.length; k++) {
            sum += nums[start + k];
            res = Math.max(res, sum + getMin(nums, start, dp, 2 + k));
        }
        return dp[start] = res;
    }

    private static int getMin(int[] nums, int start, Integer[] dp, int i) {
        return Math.min(recurse(nums, start + i, dp),
                        Math.min(recurse(nums, start + i + 1, dp),
                                 recurse(nums, start + i + 2, dp)));
    }
}
