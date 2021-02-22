package leetcode.weekly_contests.weekly_229;

import java.util.Arrays;

public class P_1770 {

    public int maximumScore(int[] nums, int[] multipliers) {
        final int m = multipliers.length;
        final int[][] dp = new int[m][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(nums, multipliers, 0, 0, dp);
    }

    private static int dfs(int[] nums, int[] mul, int i, int j, int[][] dp) {
        if (j == mul.length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int res = (int) -1e9;
        final int r = nums.length - (j - i) - 1;
        res = Math.max(res, nums[i] * mul[j] + dfs(nums, mul, i + 1, j + 1, dp));
        res = Math.max(res, nums[r] * mul[j] + dfs(nums, mul, i, j + 1, dp));
        return dp[i][j] = res;
    }
}
