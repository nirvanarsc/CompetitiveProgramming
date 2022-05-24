package leetcode.weekly_contests.weekly_200_299.weekly_291;

import java.util.HashMap;
import java.util.Map;

public class P_2 {

    public int minimumCardPickup(int[] cards) {
        final Map<Integer, Integer> map = new HashMap<>();
        final int n = cards.length;
        int res = (int) 1e9;
        for (int i = 0; i < n; i++) {
            final int u = cards[i];
            final Integer prev = map.get(u);
            if (prev != null) {
                res = Math.min(res, i - prev + 1);
            }
            map.put(u, i);
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
