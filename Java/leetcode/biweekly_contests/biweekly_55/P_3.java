package leetcode.biweekly_contests.biweekly_55;

public class P_3 {

    static long[][] dp;
    static boolean[][] seen;

    public long maxAlternatingSum(int[] nums) {
        final int n = nums.length;
        dp = new long[n][2];
        seen = new boolean[n][2];
        return dfs(nums, 0, 0);
    }

    private static long dfs(int[] nums, int idx, int flag) {
        if (idx == nums.length) {
            return 0;
        }
        if (seen[idx][flag]) {
            return dp[idx][flag];
        }
        long res = (long) -1e18;
        res = Math.max(res, dfs(nums, idx + 1, flag));
        if (flag == 0) {
            res = Math.max(res, nums[idx] + dfs(nums, idx + 1, 1));
        } else {
            res = Math.max(res, -nums[idx] + dfs(nums, idx + 1, 0));
        }
        seen[idx][flag] = true;
        return dp[idx][flag] = res;
    }
}
