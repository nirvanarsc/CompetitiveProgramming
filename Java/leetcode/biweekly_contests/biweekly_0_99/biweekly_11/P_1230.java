package leetcode.biweekly_contests.biweekly_0_99.biweekly_11;

public class P_1230 {

    public double probabilityOfHeads(double[] prob, int target) {
        return recurse(prob, target, 0, new Double[prob.length][target + 1]);
    }

    private static double recurse(double[] prob, int target, int i, Double[][] dp) {
        if (i == prob.length || target < 0) {
            return target == 0 ? 1 : 0;
        }
        if (dp[i][target] != null) {
            return dp[i][target];
        }
        return dp[i][target] = prob[i] * recurse(prob, target - 1, i + 1, dp) +
                               (1 - prob[i]) * recurse(prob, target, i + 1, dp);

    }

    public double probabilityOfHeadsBottomUp(double[] prob, int target) {
        final int n = prob.length;
        final double[][] dp = new double[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] * (1 - prob[i - 1]);
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j - 1] * prob[i - 1] + dp[i - 1][j] * (1 - prob[i - 1]);
            }
        }
        return dp[n][target];
    }
}
