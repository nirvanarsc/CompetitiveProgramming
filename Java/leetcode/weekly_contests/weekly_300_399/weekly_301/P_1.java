package leetcode.weekly_contests.weekly_300_399.weekly_301;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1 {

    public int fillCups(int[] amount) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : amount) {
            if (num > 0) {
                pq.offer(num);
            }
        }
        int res = 0;
        while (pq.size() > 1) {
            res++;
            int u = pq.remove();
            int v = pq.remove();
            if (--u > 0) {
                pq.offer(u);
            }
            if (--v > 0) {
                pq.offer(v);
            }
        }
        if (!pq.isEmpty()) {
            res += pq.remove();
        }
        return res;
    }
}
