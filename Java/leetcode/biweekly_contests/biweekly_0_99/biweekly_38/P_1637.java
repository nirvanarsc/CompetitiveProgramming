package leetcode.biweekly_contests.biweekly_0_99.biweekly_38;

import java.util.Arrays;
import java.util.Comparator;

public class P_1637 {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int best = 0;
        for (int i = 0; i < points.length - 1; i++) {
            best = Math.max(best, points[i + 1][0] - points[i][0]);
        }
        return best;
    }
}
