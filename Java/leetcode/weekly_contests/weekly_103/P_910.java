package leetcode.weekly_contests.weekly_103;

import java.util.Arrays;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_910 {

    public int smallestRangeII(int[] A, int K) {
        final int n = A.length;
        Arrays.sort(A);
        int res = A[n - 1] - A[0];
        for (int i = 1; i < n; i++) {
            final int currMin = Math.min(A[0] + K, A[i] - K);
            final int currMax = Math.max(A[i - 1] + K, A[n - 1] - K);
            res = Math.min(res, Math.abs(currMax - currMin));
        }
        return res;
    }
}
