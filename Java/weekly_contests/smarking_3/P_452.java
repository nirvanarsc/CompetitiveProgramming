package weekly_contests.smarking_3;

import java.util.Arrays;
import java.util.Comparator;

public class P_452 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int res = 1;
        int[] prev = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > prev[1]) {
                res++;
                prev = points[i];
            }
        }
        return res;
    }
}
