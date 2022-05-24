package leetcode.weekly_contests.weekly_0_99.weekly_52;

public class P_689 {

    private static int[] preSum(int[] nums) {
        final int[] preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        return preSum;
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        final int n = nums.length;
        final int m = 3;
        final int[][] dp = new int[m + 1][n + 1];
        final int[][] index = new int[m + 1][n + 1];
        final int[] sum = preSum(nums);
        for (int i = 1; i <= m; i++) {
            for (int j = i * k; j <= n; j++) {
                final int current = dp[i - 1][j - k] + sum[j] - sum[j - k];
                if (current > dp[i][j - 1]) {
                    dp[i][j] = current;
                    index[i][j] = j - k;
                } else {
                    dp[i][j] = dp[i][j - 1];
                    index[i][j] = index[i][j - 1];
                }
            }
        }
        final int[] subArrayIndex = new int[m];
        subArrayIndex[m - 1] = index[m][n];
        for (int i = m - 2; i >= 0; i--) {
            subArrayIndex[i] = index[i + 1][subArrayIndex[i + 1]];
        }
        return subArrayIndex;
    }
}
