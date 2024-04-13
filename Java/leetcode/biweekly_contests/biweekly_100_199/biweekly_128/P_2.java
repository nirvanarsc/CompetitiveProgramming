package leetcode.biweekly_contests.biweekly_100_199.biweekly_128;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class P_2 {

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        final TreeSet<Integer> ts = new TreeSet<>();
        for (int[] p : points) {
            ts.add(p[0]);
        }
        final List<Integer> list = new ArrayList<>(ts);
        int curr = -1;
        int res = 0;
        for (int num : list) {
            if (curr < num) {
                curr = num + w;
                res++;
            }
        }
        return res;
    }
}
