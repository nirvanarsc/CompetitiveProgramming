package leetcode.weekly_contests.weekly_300_399.weekly_353;

public class P_3 {

    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        final int[][] dp = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][0]);
                    dp[i + 1][1] = Math.max(dp[i + 1][1], 1 + dp[i][0]);
                    dp[i + 1][2] = Math.max(dp[i + 1][2], 1 + dp[i][0]);
                } else if (j == 1 && i > 0) {
                    if (nums1[i] >= nums1[i - 1]) {
                        dp[i + 1][1] = Math.max(dp[i + 1][1], 1 + dp[i][1]);
                    }
                    if (nums2[i] >= nums1[i - 1]) {
                        dp[i + 1][2] = Math.max(dp[i + 1][2], 1 + dp[i][1]);
                    }
                } else if (j == 2 && i > 0) {
                    if (nums1[i] >= nums2[i - 1]) {
                        dp[i + 1][1] = Math.max(dp[i + 1][1], 1 + dp[i][2]);
                    }
                    if (nums2[i] >= nums2[i - 1]) {
                        dp[i + 1][2] = Math.max(dp[i + 1][2], 1 + dp[i][2]);
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
