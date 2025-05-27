package leetcode.medium;

import java.util.Arrays;

public class P_3169 {

    public int countDays(int days, int[][] meetings) {
        final int n = meetings.length;
        final int[][] intervals = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            intervals[2 * i] = new int[] { meetings[i][0], 1 };
            intervals[2 * i + 1] = new int[] { meetings[i][1], -1 };
        }
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1])
                                                      : Integer.compare(a[0], b[0]));
        int prev = 0;
        int res = 0;
        int open = 0;
        for (int[] curr : intervals) {
            if (open == 0) {
                res += curr[0] - prev;
            }
            open += curr[1];
            prev = curr[0] + 1;
        }
        return res + (days - prev);
    }
}
