package leetcode.weekly_contests.weekly_142;

import java.util.Arrays;

public class P_1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        final int n = trips.length;
        final int[][] sorted = new int[2 * n][3];
        for (int i = 0; i < n; i++) {
            final int p = trips[i][0];
            final int from = trips[i][1];
            final int to = trips[i][2];
            sorted[2 * i] = new int[] { from, 1, p };
            sorted[2 * i + 1] = new int[] { to, -1, p };
        }
        Arrays.sort(sorted, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for (int[] curr : sorted) {
            capacity -= curr[1] * curr[2];
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}
