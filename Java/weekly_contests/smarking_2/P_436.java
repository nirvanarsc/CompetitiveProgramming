package weekly_contests.smarking_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P_436 {

    public int[] findRightInterval(int[][] intervals) {
        final TreeMap<Integer, Integer> indexes = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            indexes.put(intervals[i][0], i);
        }
        final int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            final Map.Entry<Integer, Integer> ceilingEntry = indexes.ceilingEntry(intervals[i][1]);
            res[i] = ceilingEntry == null ? -1 : ceilingEntry.getValue();
        }
        return res;
    }

    public int[] findRightIntervalBS(int[][] intervals) {
        final int n = intervals.length;
        final Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indices.put(intervals[i][0], i);
        }
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        final int[] res = new int[n];
        for (int[] curr : intervals) {
            int lo = 0;
            int hi = n - 1;
            while (lo < hi) {
                final int mid = lo + hi >>> 1;
                if (intervals[mid][0] < curr[1]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            final int currIdx = indices.get(curr[0]);
            final int targetIdx = indices.get(intervals[lo][0]);
            res[currIdx] = intervals[lo][0] >= curr[1] ? targetIdx : -1;
        }
        return res;
    }
}
