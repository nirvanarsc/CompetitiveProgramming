package leetcode.weekly_contests.weekly_0_99.weekly_81;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_823 {

    private static final int MOD = (int) (1e9 + 7);

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        final Map<Integer, Long> dp = new HashMap<>();
        final int n = arr.length;
        long res = 0L;
        for (int i = 0; i < n; i++) {
            long curr = 1;
            for (int j = 0; j < i; j++) {
                final Long u = dp.get(arr[j]);
                final Long v = dp.get(arr[i] / arr[j]);
                if (arr[i] % arr[j] == 0 && v != null) {
                    curr = (curr + u * v) % MOD;
                }
            }
            dp.put(arr[i], curr);
            res = (res + curr) % MOD;
        }
        return (int) res;
    }
}
