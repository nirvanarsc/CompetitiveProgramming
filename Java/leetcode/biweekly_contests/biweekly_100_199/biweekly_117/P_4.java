package leetcode.biweekly_contests.biweekly_100_199.biweekly_117;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_4 {

    public long maxSpending(int[][] values) {
        final int n = values.length;
        final int m = values[0].length;
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> values[a[0]][a[1]]));
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { i, m - 1 });
        }
        long res = 0;
        for (int d = 1; !pq.isEmpty(); d++) {
            final int[] p = pq.remove();
            res += (long) d * values[p[0]][p[1]];
            if (--p[1] >= 0) {
                pq.offer(p);
            }
        }
        return res;
    }
}
