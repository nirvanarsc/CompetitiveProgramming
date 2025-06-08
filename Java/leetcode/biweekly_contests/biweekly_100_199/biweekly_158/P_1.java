package leetcode.biweekly_contests.biweekly_100_199.biweekly_158;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_1 {

    public int maxSumDistinctTriplet(int[] x, int[] y) {
        final int n = x.length;
        final Map<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i < n; i++) {
            f.merge(x[i], y[i], Integer::max);
        }
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int v : f.values()) {
            pq.add(v);
            if (pq.size() > 3) {
                pq.remove();
            }
        }
        if (pq.size() != 3) {
            return -1;
        }
        int res = 0;
        while (!pq.isEmpty()) {
            res += pq.remove();
        }
        return res;
    }
}
