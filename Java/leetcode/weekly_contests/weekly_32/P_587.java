package leetcode.weekly_contests.weekly_32;

import java.util.Arrays;

public class P_587 {

    // Monotone Chain
    public int[][] outerTrees(int[][] points) {
        Arrays.sort(points, (a, b) -> b[0] == a[0] ? Integer.compare(b[1], a[1])
                                                   : Integer.compare(b[0], a[0]));
        final int n = points.length;
        final int[][] hull = new int[2 * n][];
        int k = 0;

        for (int[] point : points) {
            while (k >= 2 && orientation(hull[k - 2], hull[k - 1], point) > 0) {
                k--;
            }
            hull[k++] = point;
        }
        for (int i = n - 1; i >= 0; i--) {
            while (k >= 2 && orientation(hull[k - 2], hull[k - 1], points[i]) > 0) {
                k--;
            }
            hull[k++] = points[i];
        }
        return Arrays.stream(hull, 0, k).distinct().toArray(int[][]::new);
    }

    public int orientation(int[] a, int[] b, int[] c) {
        return (b[1] - a[1]) * (c[0] - b[0]) - (b[0] - a[0]) * (c[1] - b[1]);
    }

    public int distance(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

    private static int[] bottomLeft(int[][] points) {
        int[] bottomLeft = points[0];
        for (int[] p : points) {
            if (p[1] < bottomLeft[1]) {
                bottomLeft = p;
            }
        }
        return bottomLeft;
    }

    // Graham Scan
    public int[][] outerTreesGS(int[][] points) {
        if (points.length <= 1) { return points; }
        final int[] bm = bottomLeft(points);
        Arrays.sort(points, (p, q) -> {
            final int oLeft = orientation(bm, p, q);
            final int oRight = orientation(bm, q, p);
            return oLeft == oRight ? Integer.compare(distance(bm, p), distance(bm, q))
                                   : Integer.compare(oLeft, oRight);
        });
        int i = points.length - 1;
        while (i >= 0 && orientation(bm, points[points.length - 1], points[i]) == 0) {
            i--;
        }
        for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
            final int[] temp = points[l];
            points[l] = points[h];
            points[h] = temp;
        }
        final int[][] hull = new int[2 * points.length][];
        hull[0] = points[0];
        hull[1] = points[1];
        int k = 1;
        for (int j = 2; j < points.length; j++) {
            int[] top = hull[k--];
            while (orientation(hull[k], top, points[j]) > 0) {
                top = hull[k--];
            }
            hull[++k] = top;
            hull[++k] = points[j];
        }
        return Arrays.copyOfRange(hull, 0, k + 1);
    }
}
