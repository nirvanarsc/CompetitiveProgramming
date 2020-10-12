package leetcode.weekly_contests.weekly_203;

import java.util.ArrayList;
import java.util.List;

public class P_1560 {

    public List<Integer> mostVisited(int n, int[] rounds) {
        final List<Integer> res = new ArrayList<>();
        final int start = rounds[0];
        final int end = rounds[rounds.length - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                res.add(i);
            }
        } else {
            for (int i = 1; i <= end; i++) {
                res.add(i);
            }
            for (int i = start; i <= n; i++) {
                res.add(i);
            }
        }
        return res;
    }
}
