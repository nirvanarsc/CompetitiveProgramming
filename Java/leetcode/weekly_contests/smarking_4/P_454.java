package leetcode.weekly_contests.smarking_4;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        final Map<Integer, Integer> countAB = new HashMap<>();
        for (int ll : A) {
            for (int rr : B) {
                countAB.merge(ll + rr, 1, Integer::sum);
            }
        }
        for (int ll : C) {
            for (int rr : D) {
                final int target = ll + rr;
                res += countAB.getOrDefault(-target, 0);
            }
        }
        return res;
    }
}
