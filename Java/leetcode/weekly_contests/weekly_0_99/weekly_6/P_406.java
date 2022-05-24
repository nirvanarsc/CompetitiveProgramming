package leetcode.weekly_contests.weekly_0_99.weekly_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1])
                                                   : Integer.compare(b[0], a[0]));
        final List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(int[][]::new);
    }
}
