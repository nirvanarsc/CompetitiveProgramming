package leetcode.weekly_contests.weekly_75;

public class P_799 {

    public double champagneTower(int poured, int query_row, int query_glass) {
        final double[] dp = new double[query_row + 1];
        dp[0] = poured;
        for (int row = 1; row <= query_row; row++) {
            for (int col = row; col >= 0; col--) {
                double res = Math.max(0, dp[col] - 1) / 2;
                if (col > 0) {
                    res += Math.max(0, dp[col - 1] - 1) / 2;
                }
                dp[col] = res;
            }
        }
        return Math.min(dp[query_glass], 1.0);
    }
}
