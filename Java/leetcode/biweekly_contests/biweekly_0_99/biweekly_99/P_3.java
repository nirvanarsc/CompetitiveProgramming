package leetcode.biweekly_contests.biweekly_0_99.biweekly_99;

import java.util.Arrays;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int countWays(int[][] ranges) {
        final int n = ranges.length;
        final int[][] intervals = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            intervals[2 * i] = new int[] { ranges[i][0], 1 };
            intervals[2 * i + 1] = new int[] { ranges[i][1], -1 };
        }
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1])
                                                      : Integer.compare(a[0], b[0]));

        int open = 0;
        int total = 0;
        for (int i = 0; i < 2 * n; i++) {
            open += intervals[i][1];
            if (open == 0) {
                total++;
            }
        }
        int res = 1;
        for (int i = 0; i < total; i++) {
            res = (res * 2) % MOD;
        }
        return res;
    }
}
