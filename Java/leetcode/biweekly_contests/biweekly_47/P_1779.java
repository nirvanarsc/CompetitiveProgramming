package leetcode.biweekly_contests.biweekly_47;

import java.util.Arrays;

public class P_1779 {

    public int nearestValidPoint(int x, int y, int[][] points) {
        final int[][] indexed = new int[points.length][3];
        final int[] origin = { x, y };
        for (int i = 0; i < points.length; i++) {
            indexed[i] = new int[] { points[i][0], points[i][1], i };
        }
        Arrays.sort(indexed, (a, b) -> f(origin, a) == f(origin, b)
                                       ? Integer.compare(a[2], b[2])
                                       : Integer.compare(f(origin, a), f(origin, b)));
        for (int i = 0; i < points.length; i++) {
            if (indexed[i][0] == x || indexed[i][1] == y) {
                return indexed[i][2];
            }
        }
        return -1;
    }

    private static int f(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
