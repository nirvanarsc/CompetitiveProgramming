package weekly_contests.smarking_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_446 {

    public int numberOfArithmeticSlices(int[] A) {
        final Map<Long, List<Integer>> map = new HashMap<>();
        final int n = A.length;
        final int[][] dp = new int[n][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent((long) A[i], v -> new ArrayList<>()).add(i);
            for (int j = 0; j < i; j++) {
                final long target = 2 * (long) A[j] - A[i];
                for (int k : map.getOrDefault(target, Collections.emptyList())) {
                    if (k < j) {
                        dp[i][j] += dp[j][k] + 1;
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }

    public int numberOfArithmeticSlicesConcise(int[] A) {
        int res = 0;
        final Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(i, new HashMap<>());
            for (int j = 0; j < i; j++) {
                final long diff = (long) A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                final int d = (int) diff;
                final int c1 = map.get(i).getOrDefault(d, 0);
                final int c2 = map.get(j).getOrDefault(d, 0);
                res += c2;
                map.get(i).put(d, c1 + c2 + 1);
            }
        }
        return res;
    }
}
