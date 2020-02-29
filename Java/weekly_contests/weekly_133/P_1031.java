package weekly_contests.weekly_133;

public class P_1031 {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }

        int res = 0;
        for (int i = L - 1; i < A.length; i++) {
            final int currL = A[i] - ((i > L - 1) ? A[i - L] : 0);
            for (int k = M - 1; k < i - L + 1; k++) {
                final int currBefore = A[k] - ((k > M - 1) ? A[k - M] : 0);
                res = Math.max(res, currL + currBefore);
            }
            for (int t = i + M; t < A.length; t++) {
                final int currAfter = A[t] - A[t - M];
                res = Math.max(res, currL + currAfter);
            }
        }
        return res;
    }

    public int maxSumTwoNoOverlapFast(int[] A, int L, int M) {
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }

        int rest = A[L + M - 1];
        int lMax = A[L - 1];
        int mMax = A[M - 1];
        for (int i = L + M; i < A.length; i++) {
            lMax = Math.max(lMax, A[i - M] - A[i - (L + M)]);
            mMax = Math.max(mMax, A[i - L] - A[i - (L + M)]);
            final int curRestMax = Math.max(lMax + A[i] - A[i - M], mMax + A[i] - A[i - L]);
            rest = Math.max(rest, curRestMax);
        }
        return rest;
    }
}
