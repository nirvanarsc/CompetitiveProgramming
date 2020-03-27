package weekly_contests.weekly_81;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_823 {

    private static final int MOD = (int) (1e9 + 7);

    @SuppressWarnings("MethodParameterNamingConvention")
    public int numFactoredBinaryTrees(int[] A) {
        long res = 0L;
        Arrays.sort(A);
        final Map<Integer, Long> dp = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            long count = 1;
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0 && dp.containsKey(A[i] / A[j])) {
                    count += dp.get(A[j]) * dp.get(A[i] / A[j]);
                }
            }
            dp.put(A[i], count);
            res = (res + dp.get(A[i])) % MOD;
        }
        return (int) res;
    }
}
