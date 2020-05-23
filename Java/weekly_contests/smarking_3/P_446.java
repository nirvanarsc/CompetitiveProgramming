package weekly_contests.smarking_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_446 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int numberOfArithmeticSlices(int[] A) {
        final Map<Long, List<Integer>> map = new HashMap<>();
        final int n = A.length;
        final int[][] dp = new int[n][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent((long) A[i], v -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                final long target = 2 * (long) A[j] - A[i];
                if (map.containsKey(target)) {
                    for (int k : map.get(target)) {
                        if (k < j) {
                            dp[i][j] += dp[j][k] + 1;
                        }
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}
