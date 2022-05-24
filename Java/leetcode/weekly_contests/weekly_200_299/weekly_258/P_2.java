package leetcode.weekly_contests.weekly_200_299.weekly_258;

import java.util.HashMap;
import java.util.Map;

public class P_2 {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long interchangeableRectangles(int[][] rectangles) {
        final Map<Long, Integer> map = new HashMap<>();
        final long max = (long) 1e5;
        long res = 0;
        for (int[] rect : rectangles) {
            final int gcd = gcd(rect[0], rect[1]);
            rect[0] /= gcd;
            rect[1] /= gcd;
            final long curr = rect[0] * max + rect[1];
            res += map.getOrDefault(curr, 0);
            map.merge(curr, 1, Integer::sum);
        }
        return res;
    }
}
