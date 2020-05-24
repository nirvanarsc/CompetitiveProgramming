package weekly_contests.smarking_4;

import java.util.HashMap;
import java.util.Map;

public class P_454 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int valueA : A) {
            for (int valueB : B) {
                map.merge(valueA + valueB, 1, Integer::sum);
            }
        }
        for (int valueC : C) {
            for (int valueD : D) {
                res += map.getOrDefault(-valueC - valueD, 0);
            }
        }
        return res;
    }
}
