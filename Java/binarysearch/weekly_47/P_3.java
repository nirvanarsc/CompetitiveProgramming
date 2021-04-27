package binarysearch.weekly_47;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class P_3 {

    public int[] solve(int[][] points) {
        final Map<Integer, TreeSet<Integer>> x = new HashMap<>();
        final Map<Integer, TreeSet<Integer>> y = new HashMap<>();
        for (int[] p : points) {
            x.computeIfAbsent(p[1], val -> new TreeSet<>()).add(p[0]);
            y.computeIfAbsent(p[0], val -> new TreeSet<>()).add(p[1]);
        }
        final int[] res = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            res[i] = f(points[i], x, y);
        }
        return res;
    }

    private static int f(int[] p, Map<Integer, TreeSet<Integer>> x, Map<Integer, TreeSet<Integer>> y) {
        int res = (int) 1e9;
        final TreeSet<Integer> xx = x.get(p[1]);
        final TreeSet<Integer> yy = y.get(p[0]);
        final Integer ll = xx.lower(p[0]);
        final Integer rr = xx.higher(p[0]);
        if (ll != null) {
            res = Math.min(res, p[0] - ll);
        }
        if (rr != null) {
            res = Math.min(res, rr - p[0]);
        }
        final Integer down = yy.lower(p[1]);
        final Integer up = yy.higher(p[1]);
        if (down != null) {
            res = Math.min(res, p[1] - down);
        }
        if (up != null) {
            res = Math.min(res, up - p[1]);
        }
        return res;
    }
}
