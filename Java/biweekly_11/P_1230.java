package biweekly_11;

public class P_1230 {

    public double probabilityOfHeads(double[] prob, int target) {
        return recurse(prob, target, 0, new Double[prob.length][target + 1]);
    }

    private static double recurse(double[] prob, int target, int i, Double[][] dp) {
        if (i == prob.length && target == 0) {
            return 1;
        }
        if (target < 0 || i < 0 || i >= prob.length) {
            return 0;
        }
        if (dp[i][target] != null) {
            return dp[i][target];
        }
        return dp[i][target] = prob[i] * recurse(prob, target - 1, i + 1, dp) +
                               (1 - prob[i]) * recurse(prob, target, i + 1, dp);
    }
}
