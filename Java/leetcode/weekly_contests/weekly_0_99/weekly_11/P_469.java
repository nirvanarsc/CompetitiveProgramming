package leetcode.weekly_contests.weekly_0_99.weekly_11;

import java.util.Arrays;
import java.util.List;

public class P_469 {

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
    public int[][] convexHull(int[][] points) {
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

    public boolean isConvex(List<List<Integer>> points) {
        final int[][] p = points.stream().map(t -> new int[] { t.get(0), t.get(1) }).toArray(int[][]::new);
        return Arrays.equals(p, convexHull(p));
    }
}
