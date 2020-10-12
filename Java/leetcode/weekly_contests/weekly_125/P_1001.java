package leetcode.weekly_contests.weekly_125;

import java.util.HashMap;
import java.util.Map;

public class P_1001 {

    private static final int[][] DIRS =
            { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 0 } };

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        final Map<Integer, Integer> rows = new HashMap<>();
        final Map<Integer, Integer> cols = new HashMap<>();
        final Map<Integer, Integer> diag1 = new HashMap<>();
        final Map<Integer, Integer> diag2 = new HashMap<>();
        final Map<Integer, Boolean> switched = new HashMap<>();
        final int[] res = new int[queries.length];
        for (int[] lamp : lamps) {
            final int x = lamp[0];
            final int y = lamp[1];
            rows.merge(x, 1, Integer::sum);
            cols.merge(y, 1, Integer::sum);
            diag1.merge(x - y, 1, Integer::sum);
            diag2.merge(x + y, 1, Integer::sum);
            switched.put(N * x + y, true);
        }
        for (int i = 0; i < queries.length; i++) {
            final int x = queries[i][0];
            final int y = queries[i][1];
            res[i] = (rows.getOrDefault(x, 0) > 0
                      || cols.getOrDefault(y, 0) > 0
                      || diag1.getOrDefault(x - y, 0) > 0
                      || diag2.getOrDefault(x + y, 0) > 0) ? 1 : 0;
            for (int[] dir : DIRS) {
                final int x1 = x + dir[0];
                final int y1 = y + dir[1];
                if (switched.getOrDefault(N * x1 + y1, false)) {
                    rows.computeIfPresent(x1, (k, v) -> v - 1);
                    cols.computeIfPresent(y1, (k, v) -> v - 1);
                    diag1.computeIfPresent(x1 - y1, (k, v) -> v - 1);
                    diag2.computeIfPresent(x1 + y1, (k, v) -> v - 1);
                    switched.put(N * x1 + y1, false);
                }
            }
        }
        return res;
    }
}
