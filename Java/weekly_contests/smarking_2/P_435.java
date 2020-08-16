package weekly_contests.smarking_2;

import java.util.Arrays;

public class P_435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0])
                                                      : Integer.compare(a[1], b[1]));
        int res = 0;
        int[] prev = null;
        for (int[] curr : intervals) {
            if (prev != null && overlaps(prev, curr)) {
                res++;
            } else {
                prev = curr;
            }
        }
        return res;
    }

    private static boolean overlaps(int[] left, int[] right) {
        return !(left[1] <= right[0] || right[1] <= left[0]);
    }
}
