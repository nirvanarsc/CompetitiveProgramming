package leetcode.biweekly_contests.biweekly_15;

import java.util.Arrays;

public final class P_1288 {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1])
                                                      : Integer.compare(a[0], b[0]));
        int res = 1;
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            final int[] curr = intervals[i];
            if (prev[0] <= curr[0] && curr[1] <= prev[1]) {
                continue;
            } else {
                res++;
                prev = curr;
            }
        }
        return res;
    }
}
