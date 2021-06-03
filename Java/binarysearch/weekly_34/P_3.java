package binarysearch.weekly_34;

public class P_3 {

    static int[][][] dp;
    static boolean[][][] seen;

    public boolean solve(int[] nums, int k) {
        final int n = nums.length;
        dp = new int[n][k + 1][2];
        seen = new boolean[n][k + 1][2];
        return dfs(nums, 0, k, 0) > 0;
    }

    private static int dfs(int[] nums, int idx, int tar, int taken) {
        if (idx == nums.length) {
            return tar == 0 ? 1 : 0;
        }
        if (seen[idx][tar][taken]) {
            return dp[idx][tar][taken];
        }
        int res = 0;
        res = Math.max(res, dfs(nums, idx + 1, tar, 0));
        if (taken == 0 && nums[idx] <= tar) {
            res = Math.max(res, dfs(nums, idx + 1, tar - nums[idx], 1));
        }
        seen[idx][tar][taken] = true;
        return dp[idx][tar][taken] = res;
    }
}
