package weekly_contests.weekly_120;

public class P_977 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] sortedSquares(int[] A) {
        final int[] res = new int[A.length];
        for (int i = 0, j = A.length - 1, w = A.length - 1; i <= j; w--) {
            if (A[i] * A[i] > A[j] * A[j]) {
                res[w] = A[i] * A[i];
                i++;
            } else {
                res[w] = A[j] * A[j];
                j--;
            }
        }
        return res;
    }
}
