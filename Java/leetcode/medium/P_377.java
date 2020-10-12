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

    public int combinationSum4BottomUp(int[] candidates, int target) {
        final int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int candidate : candidates) {
                if (i - candidate >= 0) {
                    dp[i] += dp[i - candidate];
                }
            }
        }
        return dp[target];
    }
}
