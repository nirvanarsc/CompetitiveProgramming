package leetcode.weekly_contests.weekly_200_299.weekly_252;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    static boolean[][] seen;
    static int[][] dp;

    public int countSpecialSubsequences(int[] nums) {
        final int n = nums.length;
        seen = new boolean[n][4];
        dp = new int[n][4];
        return dfs(nums, 0, -1);
    }

    private static int dfs(int[] nums, int idx, int prev) {
        if (idx == nums.length) {
            return (prev == 2) ? 1 : 0;
        }
        if (seen[idx][prev + 1]) {
            return dp[idx][prev + 1];
        }
        int res = 0;
        if (prev + 1 == nums[idx] || prev == nums[idx]) {
            res = (res + dfs(nums, idx + 1, nums[idx])) % MOD;
        }
        res = (res + dfs(nums, idx + 1, prev)) % MOD;
        seen[idx][prev + 1] = true;
        return dp[idx][prev + 1] = res;
    }
}
