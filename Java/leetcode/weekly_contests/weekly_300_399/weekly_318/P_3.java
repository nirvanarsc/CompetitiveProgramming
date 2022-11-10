package leetcode.weekly_contests.weekly_300_399.weekly_318;

import java.util.PriorityQueue;

public class P_3 {

    public long totalCost(int[] costs, int k, int candidates) {
        final int n = costs.length;
        final int[] idx = { 0, n - 1 };
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0]
                                                                      ? Integer.compare(a[1], b[1])
                                                                      : Integer.compare(a[0], b[0]));
        for (int i = 0; i < candidates; i++) {
            pq.offer(new int[] { costs[idx[0]], idx[0]++, 0 });
        }
        for (int i = 0; i < candidates; i++) {
            if (idx[0] <= idx[1]) {
                pq.offer(new int[] { costs[idx[1]], idx[1]--, 1 });
            }
        }
        long res = 0;
        for (int i = 0; i < k; i++) {
            final int[] pop = pq.remove();
            res += pop[0];
            if (idx[0] <= idx[1]) {
                if (pop[2] == 0) {
                    pq.offer(new int[] { costs[idx[0]], idx[0]++, 0 });
                } else {
                    pq.offer(new int[] { costs[idx[1]], idx[1]--, 1 });
                }
            }
        }
        return res;
    }
}
