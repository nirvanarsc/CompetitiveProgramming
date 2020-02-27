package weekly_contests.weekly_136;

public class P_1043 {

    public int maxSumAfterPartitioning(int[] A, int K) {
        return recurse(A, K, 0, K, new Integer[A.length]);
    }

    private static int recurse(int[] A, int K, int i, int k, Integer[] dp) {
        if (i == A.length) {
            return 0;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        int partitionMax = Integer.MIN_VALUE;
        int arrayMax = Integer.MIN_VALUE;
        for (int j = 0; j < k && i + j < A.length; j++) {
            partitionMax = Math.max(partitionMax, A[i + j]);
            arrayMax = Math.max(arrayMax, (j + 1) * partitionMax + recurse(A, K, i + j + 1, K, dp));
        }

        return dp[i] = arrayMax;
    }
}
