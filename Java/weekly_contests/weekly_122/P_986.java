package weekly_contests.weekly_122;

import java.util.ArrayList;
import java.util.List;

public class P_986 {

    public static final int[][] INTS = new int[0][];

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        final List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            final int startMax = Math.max(A[i][0], B[j][0]);
            final int endMin = Math.min(A[i][1], B[j][1]);

            if (endMin >= startMax) { list.add(new int[] { startMax, endMin }); }
            if (A[i][1] == endMin) { i++; }
            if (B[j][1] == endMin) { j++; }
        }
        return list.toArray(INTS);
    }
}
