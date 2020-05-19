package weekly_contests.weekly_8;

import java.util.Arrays;

public class P_416 {

    public boolean canPartition(int[] nums) {
        final int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        return dfs(nums, sum / 2, 0, new Boolean[nums.length][sum]);
    }

    private static boolean dfs(int[] nums, int t, int idx, Boolean[][] dp) {
        if (t <= 0) {
            return t == 0;
        }
        if (idx == nums.length) {
            return false;
        }
        if (dp[idx][t] != null) {
            return dp[idx][t];
        }
        final boolean skip = dfs(nums, t, idx + 1, dp);
        final boolean take = dfs(nums, t - nums[idx], idx + 1, dp);
        return dp[idx][t] = skip | take;
    }
}
