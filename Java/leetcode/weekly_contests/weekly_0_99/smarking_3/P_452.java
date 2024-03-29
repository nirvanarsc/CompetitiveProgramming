package leetcode.weekly_contests.weekly_0_99.smarking_3;

import java.util.Arrays;
import java.util.Comparator;

public class P_452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int res = 1;
        int[] prev = points[0];
        for (int[] p : points) {
            if (!overlaps(p, prev)) {
                res++;
                prev = p;
            }
        }
        return res;
    }

    private static boolean overlaps(int[] left, int[] right) {
        return !(left[1] < right[0] || right[1] < left[0]);
    }
}
