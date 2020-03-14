package weekly_contests.weekly_103;

import java.util.Arrays;

public class P_910 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int res = A[A.length - 1] - A[0];
        final int defaultMax = A[A.length - 1] - K;
        final int defaultMin = A[0] + K;
        for (int i = 0; i < A.length - 1; i++) {
            res = Math.min(res, Math.max(A[i] + K, defaultMax) - Math.min(A[i + 1] - K, defaultMin));
        }
        return res;
    }
}
