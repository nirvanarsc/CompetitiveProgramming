package leetcode.biweekly_contests.biweekly_0_99.biweekly_14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1272 {

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        final List<List<Integer>> res = new ArrayList<>();
        final int rStart = toBeRemoved[0];
        final int rEnd = toBeRemoved[1];

        for (int[] interval : intervals) {
            final int start = interval[0];
            final int end = interval[1];

            if (end <= rStart || rEnd <= start) {
                res.add(Arrays.asList(start, end));
            } else if (start < rStart && rEnd < end) {
                res.add(Arrays.asList(start, rStart));
                res.add(Arrays.asList(rEnd, end));
            } else if (start < rStart && end < rEnd) {
                res.add(Arrays.asList(start, rStart));
            } else if (rStart <= start && rEnd < end) {
                res.add(Arrays.asList(rEnd, end));
            }
        }

        return res;
    }
}
