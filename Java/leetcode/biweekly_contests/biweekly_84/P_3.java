package leetcode.biweekly_contests.biweekly_84;

import java.util.HashMap;
import java.util.Map;

public class P_3 {

    public long taskSchedulerII(int[] tasks, int space) {
        long res = 0;
        final Map<Integer, Long> f = new HashMap<>();
        for (int t : tasks) {
            res += Math.max(0, f.getOrDefault(t, -1L) - res + 1);
            f.put(t, res + space);
            res++;
        }
        return res;
    }
}
