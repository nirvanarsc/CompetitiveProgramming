package leetcode.weekly_contests.weekly_300_399.weekly_369;

public class P_3 {

    public long minIncrementOperations(int[] nums, int k) {
        final int n = nums.length;
        final long[] dp = new long[n + 3];
        for (int i = 0; i < n; i++) {
            dp[i + 3] = Math.max(0, k - nums[i]) + f(dp, i);
        }
        return f(dp, n);
    }

    private static long f(long[] dp, int i) {
        return Math.min(dp[i], Math.min(dp[i + 1], dp[i + 2]));
    }
}
