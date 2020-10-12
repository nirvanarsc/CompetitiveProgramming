package leetcode.weekly_contests.weekly_194;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class P_1488 {

    @SuppressWarnings("ZeroLengthArrayAllocation")
    public int[] avoidFlood(int[] rains) {
        final int[] res = new int[rains.length];
        final TreeSet<Integer> empty = new TreeSet<>();
        final Map<Integer, Integer> full = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0 && full.containsKey(rains[i])) {
                final Integer higher = empty.higher(full.get(rains[i]));
                if (higher == null) {
                    return new int[0];
                }
                empty.remove(higher);
                res[higher] = rains[i];
                res[i] = -1;
                full.put(rains[i], i);
            } else if (rains[i] > 0) {
                res[i] = -1;
                full.put(rains[i], i);
            } else if (rains[i] == 0) {
                empty.add(i);
            }
        }
        for (int idx : empty) {
            res[idx] = 1;
        }
        return res;
    }
}
