package leetcode.weekly_contests.weekly_0_99.weekly_84;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_835 {

    public int largestOverlap(int[][] img1, int[][] img2) {
        int res = 0;
        final int n = img1.length;
        final int m = (int) 1e2;
        final List<Integer> l = new ArrayList<>();
        final List<Integer> r = new ArrayList<>();
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    l.add(i * m + j);
                }
                if (img2[i][j] == 1) {
                    r.add(i * m + j);
                }
            }
        }
        for (int a : l) {
            for (int b : r) {
                res = Math.max(res, map.merge(a - b, 1, Integer::sum));
            }
        }
        return res;
    }
}
