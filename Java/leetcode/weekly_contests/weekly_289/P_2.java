package leetcode.weekly_contests.weekly_289;

import java.util.HashMap;
import java.util.Map;

public class P_2 {

    public int minimumRounds(int[] tasks) {
        int res = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int t : tasks) {
            map.merge(t, 1, Integer::sum);
        }
        for (int v : map.values()) {
            final int m = v % 3;
            if (m == 0) {
                res += v / 3;
            } else if (m == 1) {
                if (v == 1) {
                    return -1;
                }
                res += 2 + (v - 4) / 3;
            } else {
                res += 1 + (v - 2) / 3;
            }
        }
        return res;
    }
}
