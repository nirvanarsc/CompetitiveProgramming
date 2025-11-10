package leetcode.weekly_contests.weekly_400_499.weekly_473;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_3 {

    public long countStableSubarrays(int[] capacity) {
        final int n = capacity.length;
        long res = 0;
        long curr = 0;
        final Map<Long, Map<Long, Long>> f = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final long v = capacity[i];
            curr += v;
            res += f.getOrDefault(v, Collections.emptyMap())
                    .getOrDefault(curr - 2 * capacity[i], 0L);
            f.computeIfAbsent(v, val -> new HashMap<>())
             .merge(curr, 1L, Long::sum);
            if (i > 0 && capacity[i] == 0 && capacity[i - 1] == 0) {
                res--;
            }
        }
        return res;
    }
}
