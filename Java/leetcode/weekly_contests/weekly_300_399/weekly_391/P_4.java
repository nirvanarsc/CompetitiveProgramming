package leetcode.weekly_contests.weekly_300_399.weekly_391;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P_4 {

    public int minimumDistance(int[][] points) {
        final int n = points.length;
        final int[] idx = f(points, n);
        return Math.min(f(points, n, idx[0]), f(points, n, idx[1]));
    }

    private static int[] f(int[][] p, int n) {
        final List<int[]> l = new ArrayList<>();
        final List<int[]> r = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l.add(new int[] { p[i][0] + p[i][1], i });
            r.add(new int[] { p[i][0] - p[i][1], i });
        }
        l.sort(Comparator.comparingInt(a -> a[0]));
        r.sort(Comparator.comparingInt(a -> a[0]));
        return l.get(l.size() - 1)[0] - l.get(0)[0] > r.get(r.size() - 1)[0] - r.get(0)[0] ?
               new int[] { l.get(l.size() - 1)[1], l.get(0)[1] } :
               new int[] { r.get(r.size() - 1)[1], r.get(0)[1] };
    }

    private static int f(int[][] p, int n, int bannedIdx) {
        final List<int[]> l = new ArrayList<>();
        final List<int[]> r = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == bannedIdx) {
                continue;
            }
            l.add(new int[] { p[i][0] + p[i][1], i });
            r.add(new int[] { p[i][0] - p[i][1], i });
        }
        l.sort(Comparator.comparingInt(a -> a[0]));
        r.sort(Comparator.comparingInt(a -> a[0]));
        return Math.max(l.get(l.size() - 1)[0] - l.get(0)[0], r.get(r.size() - 1)[0] - r.get(0)[0]);
    }
}
