package weekly_contests.weekly_79;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_813 {

    public double largestSumOfAverages(int[] A, int K) {
        final double[] prefixSum = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            prefixSum[i] = (i == 0 ? 0 : prefixSum[i - 1]) + A[i];
        }
        return dfs(A, K, 0, prefixSum, new Double[A.length][K + 1]);
    }

    private static double dfs(int[] A, int K, int i, double[] prefixSum, Double[][] dp) {
        if (K == 1) {
            return (prefixSum[A.length - 1] - prefixSum[i] + A[i]) / (A.length - i);
        }
        if (dp[i][K] != null) {
            return dp[i][K];
        }

        double curr = 0;
        for (int c = i; c <= A.length - K; c++) {
            final double avg = (prefixSum[c] - prefixSum[i] + A[i]) / (c - i + 1);
            curr = Math.max(curr, avg + dfs(A, K - 1, c + 1, prefixSum, dp));
        }

        return dp[i][K] = curr;
    }
}
