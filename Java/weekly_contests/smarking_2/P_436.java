package weekly_contests.smarking_2;

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
}
