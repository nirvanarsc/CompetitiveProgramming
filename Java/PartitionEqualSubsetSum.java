public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        final boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i : nums) {
            for (int j = sum / 2; j >= i; j--) {
                dp[j] |= dp[j - i];
            }
        }

        return dp[sum / 2];
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }

        final int k = sum / 2;
        final int[][] dp = new int[nums.length][k + 1];

        for (int i = 0; i <= k; i++) {
            if (nums[0] <= i) {
                dp[0][i] = nums[0];
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int n = 0; n <= k; n++) {
                if (n >= nums[i]) {
                    dp[i][n] = Math.max(dp[i - 1][n], dp[i - 1][n - nums[i]] + nums[i]);
                } else {
                    dp[i][n] = dp[i - 1][n];
                }
            }
        }

        return dp[nums.length - 1][k] == k;
    }
}
