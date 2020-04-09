package weekly_contests.weekly_65;

import java.util.Arrays;

public class P_757 {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1])
                                                      : Integer.compare(a[0], b[0]));
        final int[] todo = new int[intervals.length];
        Arrays.fill(todo, 2);
        int ans = 0, t = intervals.length;
        while (--t >= 0) {
            final int m = todo[t];
            for (int p = intervals[t][0]; p < intervals[t][0] + m; ++p) {
                for (int i = 0; i <= t; ++i) {
                    if (todo[i] > 0 && p <= intervals[i][1]) {
                        todo[i]--;
                    }
                }
                ans++;
            }
        }
        return ans;
    }
}
