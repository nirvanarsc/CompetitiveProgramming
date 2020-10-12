package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P_57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        final List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                res.add(interval);
            } else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        if (newInterval != null) {
            res.add(newInterval);
        }
        return res.toArray(int[][]::new);
    }

    public int[][] insertList(int[][] intervals, int[] newInterval) {
        final List<int[]> disjointIntervals = Arrays.stream(intervals).collect(Collectors.toList());
        final List<int[]> res = new ArrayList<>();
        int i;
        for (i = 0; i < disjointIntervals.size(); i++) {
            final int[] curr = disjointIntervals.get(i);
            if (overlaps(newInterval, curr)) {
                newInterval[0] = Math.min(newInterval[0], curr[0]);
                newInterval[1] = Math.max(newInterval[1], curr[1]);
            } else if (curr[1] < newInterval[0]) {
                res.add(curr);
            } else {
                break;
            }
        }
        res.add(newInterval);
        res.addAll(disjointIntervals.subList(i, disjointIntervals.size()));
        return res.toArray(int[][]::new);
    }

    private static boolean overlaps(int[] left, int[] right) {
        return !(left[1] < right[0] || right[1] < left[0]);
    }
}
