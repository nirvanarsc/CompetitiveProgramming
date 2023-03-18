package leetcode.biweekly_contests.biweekly_0_99.biweekly_22;

public class P_1388 {

    public int maxSizeSlices(int[] slices) {
        return Math.max(rob(slices, 0), rob(slices, 1));
    }

    private static int rob(int[] slices, int s) {
        final int[][] dp = new int[slices.length][slices.length / 3 + 1];
        dp[1][1] = slices[s];
        for (int i = 2; i < slices.length; i++) {
            for (int j = 1; j <= slices.length / 3; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + slices[i - 1 + s]);
            }
        }
        return dp[slices.length - 1][slices.length / 3];
    }
}
