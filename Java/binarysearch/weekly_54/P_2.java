package binarysearch.weekly_54;

import java.util.Map;
import java.util.TreeMap;

public class P_2 {

    public int solve(int[] walks, int target) {
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        int idx = 0;
        for (int w : walks) {
            if (w > 0) {
                tm.merge(idx, 1, Integer::sum);
                tm.merge(idx + w, -1, Integer::sum);
            } else {
                tm.merge(idx + w, 1, Integer::sum);
                tm.merge(idx, -1, Integer::sum);
            }
            idx += w;
        }
        int prev = 0;
        int curr = 0;
        int res = 0;
        for (Map.Entry<Integer, Integer> e : tm.entrySet()) {
            if (curr >= target) {
                res += e.getKey() - prev;
            }
            curr += e.getValue();
            prev = e.getKey();
        }
        return res;
    }
}
