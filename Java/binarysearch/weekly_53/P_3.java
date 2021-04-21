package binarysearch.weekly_53;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P_3 {

    public int[][] solve(int[][] intervals) {
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int[] w : intervals) {
            tm.merge(w[0], w[2], Integer::sum);
            tm.merge(w[1] + 1, -w[2], Integer::sum);
        }
        int curr = 0;
        int max = (int) -2e9;
        final List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : tm.entrySet()) {
            curr += e.getValue();
            max = Math.max(max, curr);
        }
        for (Map.Entry<Integer, Integer> e : tm.entrySet()) {
            if (curr == max) {
                list.get(list.size() - 1)[1] = e.getKey();
            }
            curr += e.getValue();
            if (curr == max) {
                list.add(new int[] { e.getKey(), -1 });
            }
        }
        final int[][] merged = merge(list);
        for (int[] w : merged) {
            w[1]--;
        }
        return merged;
    }

    public int[][] merge(List<int[]> intervals) {
        final List<int[]> res = new ArrayList<>();
        int[] prev = intervals.get(0);
        for (int[] interval : intervals) {
            if (overlaps(prev, interval)) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                res.add(prev);
                prev = interval;
            }
        }
        res.add(prev);
        return res.toArray(int[][]::new);
    }

    private static boolean overlaps(int[] left, int[] right) {
        return !(left[1] < right[0] || right[1] < left[0]);
    }
}
