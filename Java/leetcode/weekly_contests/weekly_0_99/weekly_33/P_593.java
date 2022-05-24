package leetcode.weekly_contests.weekly_0_99.weekly_33;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_593 {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        final Set<Integer> set = new HashSet<>(Arrays.asList(distance(p1, p2), distance(p1, p3),
                                                             distance(p1, p4), distance(p2, p3),
                                                             distance(p2, p4), distance(p3, p4)));
        return !set.contains(0) && set.size() == 2;
    }

    private static int distance(int[] a, int[] b) {
        final int dy = b[1] - a[1];
        final int dx = b[0] - a[0];
        return dy * dy + dx * dx;
    }
}
