package weekly_contests.smarking_2;

import java.util.Arrays;

public class P_435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0])
                                                      : Integer.compare(a[1], b[1]));
        int res = 0;
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev[1]) {
                res++;
            } else {
                prev = intervals[i];
            }
        }
        return res;
    }
}
