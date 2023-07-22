package leetcode.biweekly_contests.biweekly_100_199.biweekly_109;

public class P_3 {

    public long maxScore(int[] nums, int x) {
        final int n = nums.length;
        final long[][] dp = new long[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][nums[0] % 2] = nums[0];
            dp[i][1 ^ (nums[0] % 2)] = nums[0] - x;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                if (nums[i] % 2 == j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + nums[i]);
                } else {
                    dp[i][1 ^ j] = Math.max(dp[i][1 ^ j], dp[i - 1][j] + nums[i] - x);
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
