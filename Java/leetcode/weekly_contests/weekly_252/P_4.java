package leetcode.weekly_contests.weekly_252;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    static boolean[][] seen;
    static int[][] dp;

    public int countSpecialSubsequences(int[] nums) {
        final int n = nums.length;
        seen = new boolean[n][4];
        dp = new int[n][4];
        return dfs(nums, 0, 0);
    }

    private static int dfs(int[] nums, int idx, int tar) {
        if (idx == nums.length) {
            return (tar == 3) ? 1 : 0;
        }
        if (seen[idx][tar]) {
            return dp[idx][tar];
        }
        int res = 0;
        if (nums[idx] == 0) {
            if (tar == 0) {
                res = (res + dfs(nums, idx + 1, 1)) % MOD;
                res = (res + dfs(nums, idx + 1, 0)) % MOD;
            }
            res = (res + dfs(nums, idx + 1, 1)) % MOD;
            res = (res + dfs(nums, idx + 1, 0)) % MOD;
        } else if (nums[idx] == 1) {
            if (tar == 1) {
                res = (res + dfs(nums, idx + 1, 2)) % MOD;
                res = (res + dfs(nums, idx + 1, 1)) % MOD;
            }
        } else {
            if (tar == 2) {
                res = (res + dfs(nums, idx + 1, 3)) % MOD;
            } else if (tar == 3) {
                res = (res + 1 + dfs(nums, idx + 1, 3)) % MOD;
            }
        }
        seen[idx][tar] = true;
        return dp[idx][tar] = res;
    }
}
