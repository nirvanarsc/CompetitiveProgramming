package easy;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_985 {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        final int[] res = new int[queries.length];
        int idx = 0;
        int evenSum = 0;
        for (int i : A) {
            if ((i & 1) == 0) {
                evenSum += i;
            }
        }
        for (int[] query : queries) {
            if ((A[query[1]] & 1) == 0) {
                evenSum -= A[query[1]];
            }
            A[query[1]] += query[0];
            if ((A[query[1]] & 1) == 0) {
                evenSum += A[query[1]];
            }
            res[idx++] = evenSum;
        }
        return res;
    }
}
