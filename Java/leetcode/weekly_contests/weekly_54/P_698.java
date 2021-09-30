package leetcode.weekly_contests.weekly_54;

import java.util.Arrays;

public class P_698 {

    static boolean[] good;
    static boolean[][] seen;
    static int[][] dp;
    static int n;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        final int sum = Arrays.stream(nums).sum();
        final int target = sum / k;
        if (target * k != sum) {
            return false;
        }
        n = nums.length;
        good = new boolean[1 << n];
        seen = new boolean[1 << n][k + 1];
        dp = new int[1 << n][k + 1];
        for (int mask = 0; mask < (1 << n); mask++) {
            int curr = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr += nums[i];
                }
            }
            if (curr == target) {
                good[mask] = true;
            }
        }
        return dfs((1 << n) - 1, k) == 1;
    }

    private static int dfs(int mask, int k) {
        if (k == 0) {
            return mask == 0 ? 1 : 0;
        }
        if (seen[mask][k]) {
            return dp[mask][k];
        }
        int res = 0;
        for (int subMask = mask; subMask > 0; subMask = (subMask - 1) & mask) {
            if (good[subMask]) {
                res = Math.max(res, dfs(mask ^ subMask, k - 1));
            }
        }
        seen[mask][k] = true;
        return dp[mask][k] = res;
    }
}
