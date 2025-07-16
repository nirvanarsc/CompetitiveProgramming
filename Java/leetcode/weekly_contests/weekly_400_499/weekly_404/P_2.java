package leetcode.weekly_contests.weekly_400_499.weekly_404;

public class P_2 {

    public int maximumLength(int[] nums) {
        final int k = 2;
        final int[][] dp = new int[k][k];
        for (int num : nums) {
            final int v = num % k;
            for (int s = 0; s < k; s++) {
                final int u = (s - v + k) % k;
                dp[s][v] = 1 + dp[s][u];
            }
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
