package weekly_contests.weekly_97;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_885 {

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    public static final int[][] INTS = new int[0][];

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        final List<int[]> res = new ArrayList<>();
        int currDir = 0;
        int travel = 1;
        if (withinBounds(r0, c0, R, C)) {
            res.add(new int[] { r0, c0 });
        }
        while (res.size() < R * C) {
            for (int i = 0; i < travel; i++) {
                r0 += DIRS[currDir][0];
                c0 += DIRS[currDir][1];
                if (withinBounds(r0, c0, R, C)) {
                    res.add(new int[] { r0, c0 });
                }
            }
            currDir = (currDir + 1) % 4;
            if (currDir == 2) {
                travel++;
            }
        }
        return res.toArray(INTS);
    }

    private static boolean withinBounds(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
