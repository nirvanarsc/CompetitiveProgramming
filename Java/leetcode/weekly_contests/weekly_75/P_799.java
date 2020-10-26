package leetcode.weekly_contests.weekly_75;

public class P_799 {

    public double champagneTower(int poured, int query_row, int query_glass) {
        final double[] dp = new double[query_row + 1];
        dp[0] = poured;
        for (int row = 1; row <= query_row; row++) {
            for (int col = row; col >= 0; col--) {
                final double up = Math.max(0, dp[col] - 1) * 0.5;
                final double upL = col > 0 ? Math.max(0, dp[col - 1] - 1) * 0.5 : 0;
                dp[col] = up + upL;
            }
        }
        return Math.min(1.0, dp[query_glass]);
    }
}
