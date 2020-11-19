package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class P_56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(val -> val[0]));
        final List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
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

