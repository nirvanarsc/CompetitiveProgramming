public final class SumEvenNumbersAfterQueries {
    public static int[] sumEvenAfterQueries(int[] a, int[][] queries) {
        final int[] res = new int[queries.length];
        int idx = 0;
        int evenSum = 0;
        for (int i : a) {
            if ((i & 1) == 0) {
                evenSum += i;
            }
        }
        for (int[] query : queries) {
            if ((a[query[1]] & 1) == 0) {
                evenSum -= a[query[1]];
            }
            a[query[1]] += query[0];
            if ((a[query[1]] & 1) == 0) {
                evenSum += a[query[1]];
            }
            res[idx++] = evenSum;
        }
        return res;
    }

    private SumEvenNumbersAfterQueries() {}
}
