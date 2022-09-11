package leetcode.weekly_contests.weekly_300_399.weekly_310;

import java.util.Arrays;

public class P_3 {

    public int minGroups(int[][] intervals) {
        final int n = intervals.length;
        final int[][] p = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            p[2 * i] = new int[] { intervals[i][0], 1 };
            p[2 * i + 1] = new int[] { intervals[i][1], -1 };
        }
        Arrays.sort(p, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int curr = 0;
        int max = 0;
        for (int[] pp : p) {
            curr += pp[1];
            max = Math.max(max, curr);
        }
        return max;
    }
}
