package leetcode.weekly_contests.weekly_93;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_870 {

    public int[] advantageCount(int[] A, int[] B) {
        final int n = A.length;
        final int[] res = new int[n];
        Arrays.sort(A);
        final int[][] indexed = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexed[i] = new int[] { B[i], i };
        }
        Arrays.sort(indexed, Comparator.comparingInt(a -> a[0]));
        int lo = 0;
        int hi = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            final int j = indexed[i][1];
            final int v = indexed[i][0];
            if (v < A[hi]) {
                res[j] = A[hi--];
            } else {
                res[j] = A[lo++];
            }
        }
        return res;
    }
}
