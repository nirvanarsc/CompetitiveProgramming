package weekly_contests.smarking_3;

import java.util.HashMap;
import java.util.Map;

public class P_447 {

    public int numberOfBoomerangs(int[][] points) {
        final Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] left : points) {
            for (int[] right : points) {
                map.merge(d(left, right), 1, Integer::sum);
            }
            for (int val : map.values()) {
                res += val * (val - 1);
            }
            map.clear();
        }
        return res;
    }

    private static int d(int[] p1, int[] p2) {
        final int absX = p1[0] - p2[0];
        final int absY = p1[1] - p2[1];
        return absX * absX + absY * absY;
    }
}
