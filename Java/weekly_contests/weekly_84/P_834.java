package weekly_contests.weekly_84;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_834 {

    public int largestOverlapMap(int[][] A, int[][] B) {
        int res = 0;
        final int N = A.length;
        final List<int[]> listA = new ArrayList<>();
        final List<int[]> listB = new ArrayList<>();
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 1) {
                    listA.add(new int[] { i, j });
                }
                if (B[i][j] == 1) {
                    listB.add(new int[] { i, j });
                }
            }
        }
        for (int[] a : listA) {
            for (int[] b : listB) {
                final String key = (a[0] - b[0]) + "," + (a[1] - b[1]);
                res = Math.max(res, map.merge(key, 1, Integer::sum));
            }
        }
        return res;
    }

    public static int largestOverlap(int[][] A, int[][] B) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                res = Math.max(res, f(A, B, i, j));
                res = Math.max(res, f(B, A, i, j));
            }
        }
        return res;
    }

    private static int f(int[][] A, int[][] B, int i, int j) {
        int res = 0;
        for (int k = i; k < A.length; k++) {
            for (int l = j; l < A[k].length; l++) {
                if (A[k][l] == 1 && B[k - i][l - j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
