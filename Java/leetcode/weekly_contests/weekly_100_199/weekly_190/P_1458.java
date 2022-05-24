package leetcode.weekly_contests.weekly_100_199.weekly_190;

public class P_1458 {

    public int maxDotProductBottomUp(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        final int m = nums2.length;
        final int[][] dp = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dp[i][j] = nums1[i] * nums2[j];
                if (i > 0 && j > 0) { dp[i][j] += Math.max(dp[i - 1][j - 1], 0); }
                if (i > 0) { dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]); }
                if (j > 0) { dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]); }
            }
        }
        return dp[n - 1][m - 1];
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        return dfs(nums1, nums2, 0, 0, new Integer[nums1.length][nums2.length]);
    }

    private static int dfs(int[] nums1, int[] nums2, int i, int j, Integer[][] dp) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int res = nums1[i] * nums2[j];
        final int skipBoth = dfs(nums1, nums2, i + 1, j + 1, dp);
        final int skipL = dfs(nums1, nums2, i + 1, j, dp);
        final int skipR = dfs(nums1, nums2, i, j + 1, dp);
        if (skipBoth != 0) {
            res = Math.max(res, res + skipBoth);
        }
        if (skipL != 0) {
            res = Math.max(res, skipL);
        }
        if (skipR != 0) {
            res = Math.max(res, skipR);
        }
        return dp[i][j] = res;
    }
}
