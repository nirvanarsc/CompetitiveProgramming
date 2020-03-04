package weekly_contests.weekly_122;

public class P_985 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int evenSum = 0;
        for (int num : A) {
            evenSum += num % 2 == 0 ? num : 0;
        }
        final int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (A[queries[i][1]] % 2 == 0) {
                evenSum -= A[queries[i][1]];
            }
            A[queries[i][1]] += queries[i][0];
            if (A[queries[i][1]] % 2 == 0) {
                evenSum += A[queries[i][1]];
            }
            res[i] = evenSum;
        }
        return res;
    }
}
