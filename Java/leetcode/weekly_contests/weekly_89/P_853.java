package leetcode.weekly_contests.weekly_89;

import java.util.Arrays;
import java.util.Comparator;

public class P_853 {

    public int carFleet(int target, int[] position, int[] speed) {
        final int n = position.length;
        final double[][] cars = new double[n][2];
        int res = 0;
        double cur = 0;
        for (int i = 0; i < n; ++i) {
            cars[i] = new double[] { position[i], (double) (target - position[i]) / speed[i] };
        }
        Arrays.sort(cars, Comparator.comparingDouble(a -> a[0]));
        for (int i = n - 1; i >= 0; --i) {
            if (cars[i][1] > cur) {
                cur = cars[i][1];
                res++;
            }
        }
        return res;
    }
}
