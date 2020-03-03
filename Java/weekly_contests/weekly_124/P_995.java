package weekly_contests.weekly_124;

public class P_995 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int minKBitFlips(int[] A, int K) {
        final int n = A.length;
        final int[] isFlipped = new int[n];
        int flipped = 0, res = 0;
        for (int i = 0; i < A.length; ++i) {
            if (i >= K) {
                flipped ^= isFlipped[i - K];
            }
            if (flipped == A[i]) {
                if (i + K > A.length) {
                    return -1;
                }
                isFlipped[i] = 1;
                flipped ^= 1;
                res++;
            }
        }
        return res;
    }
}
