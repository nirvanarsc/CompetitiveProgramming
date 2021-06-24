package binarysearch.weekly_30;

import java.util.HashMap;
import java.util.Map;

public class P_1 {

    public int solve(int[] tasks, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        int t = 0;
        for (int task : tasks) {
            final int prev = map.getOrDefault(task, t);
            t = Math.max(t, prev);
            t++;
            map.put(task, t + k);
        }
        return t;
    }
}
