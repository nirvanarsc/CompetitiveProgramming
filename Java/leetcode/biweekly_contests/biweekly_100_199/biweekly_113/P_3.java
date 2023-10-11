package leetcode.biweekly_contests.biweekly_100_199.biweekly_113;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_3 {

    public int countPairs(List<List<Integer>> coordinates, int k) {
        final Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
        int res = 0;
        for (List<Integer> c : coordinates) {
            final int u = c.get(0);
            final int v = c.get(1);
            for (int w = 0; w <= k; w++) {
                res += g.getOrDefault(w ^ u, Collections.emptyMap())
                        .getOrDefault((k - w) ^ v, 0);
            }
            g.computeIfAbsent(u, val -> new HashMap<>()).merge(v, 1, Integer::sum);
        }
        return res;
    }
}
