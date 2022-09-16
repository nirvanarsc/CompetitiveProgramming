package leetcode.weekly_contests.weekly_200_299.weekly_229;

import java.util.Arrays;

public class P_1770 {

    static int n;
    static int m;
    static boolean[][] seen;
    static int[][] dp;

    public int maximumScoreTopDown(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        seen = new boolean[m][m];
        dp = new int[m][m];
        return dfs(nums, multipliers, 0, 0);
    }

    private static int dfs(int[] nums, int[] mul, int i, int j) {
        if (j == m) {
            return 0;
        }
        if (seen[i][j]) {
            return dp[i][j];
        }
        int res = (int) -1e9;
        final int r = n - 1 - (j - i);
        res = Math.max(res, nums[i] * mul[j] + dfs(nums, mul, i + 1, j + 1));
        res = Math.max(res, nums[r] * mul[j] + dfs(nums, mul, i, j + 1));
        seen[i][j] = true;
        return dp[i][j] = res;
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        final int n = nums.length;
        final int m = multipliers.length;
        final int[][] dp = new int[m + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, (int) -2e9);
        }
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == (int) -2e9) {
                    continue;
                }
                final int r = n - 1 - (j - i);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + nums[i] * multipliers[j]);
                dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + nums[r] * multipliers[j]);
            }
        }
        int res = (int) -2e9;
        for (int i = 0; i <= m; i++) {
            res = Math.max(res, dp[i][m]);
        }
        return res;
    }
}
