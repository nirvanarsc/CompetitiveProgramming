package leetcode.medium;

public class P_416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        final int target = sum / 2;
        final boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int s = target; s >= 0; s--) {
                if (num <= s) {
                    dp[s] |= dp[s - num];
                }
            }
        }
        return dp[target];
    }

    public boolean canPartitionTopDown(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return dfs(nums, sum / 2, 0, 0, new Boolean[nums.length][sum / 2 + 1]);
    }

    private static boolean dfs(int[] nums, int target, int index, int sum, Boolean[][] dp) {
        if (index == nums.length) {
            return sum == target;
        }
        if (dp[index][sum] != null) {
            return dp[index][sum];
        }
        boolean res = dfs(nums, target, index + 1, sum, dp);
        if (sum + nums[index] <= target) {
            res |= dfs(nums, target, index + 1, sum + nums[index], dp);
        }
        return dp[index][sum] = res;
    }
}
