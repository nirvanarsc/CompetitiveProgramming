package leetcode.medium;

import java.util.Arrays;

public class P_377 {

    public int combinationSum4(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(candidates, target, new Integer[target + 1]);
    }

    private static int dfs(int[] candidates, int target, Integer[] dp) {
        if (target == 0) {
            return 1;
        }
        if (dp[target] != null) {
            return dp[target];
        }
        int res = 0;
        for (int candidate : candidates) {
            if (target < candidate) {
                break;
            }
            res += dfs(candidates, target - candidate, dp);
        }
        return dp[target] = res;
    }

    public int combinationSum4BottomUp(int[] nums, int target) {
        final int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int sum = 0; sum <= target; sum++) {
            for (int num : nums) {
                if (sum + num <= target) {
                    dp[sum + num] += dp[sum];
                }
            }
        }
        return dp[target];
    }
}
