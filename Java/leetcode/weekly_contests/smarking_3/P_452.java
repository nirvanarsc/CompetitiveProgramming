package leetcode.weekly_contests.smarking_3;

import java.util.Arrays;
import java.util.Comparator;

public class P_452 {

    public int findMinArrowShotsOverlap(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int res = 0;
        int[] prev = null;
        for (int[] p : points) {
            if (prev == null || !overlaps(p, prev)) {
                res++;
                prev = p;
            }
        }
        return res;
    }

    private static boolean overlaps(int[] left, int[] right) {
        return !(left[1] < right[0] || right[1] < left[0]);
    }

    public int findMinArrowShots(int[][] points) {
        final int n = points.length;
        final int[][] sorted = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            sorted[2 * i] = new int[] { points[i][0], 1, i };
            sorted[2 * i + 1] = new int[] { points[i][1], -1, i };
        }
        Arrays.sort(sorted, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int res = 0;
        int idx = 0;
        final boolean[] popped = new boolean[n];
        final int[] dq = new int[n];
        for (int[] p : sorted) {
            if (popped[p[2]]) {
                continue;
            }
            if (p[1] == -1) {
                int curr = 0;
                while (idx > 0) {
                    final int u = dq[--idx];
                    if (!popped[u]) {
                        popped[u] = true;
                        curr++;
                    }
                }
                if (curr > 0) {
                    res++;
                }
            } else {
                dq[idx++] = p[2];
            }
        }
        return res;
    }
}
