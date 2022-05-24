package leetcode.weekly_contests.weekly_200_299.weekly_248;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_2 {

    public int eliminateMaximum(int[] dist, int[] speed) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> (a[0] + a[1] - 1) / a[1]));
        for (int i = 0; i < dist.length; i++) {
            pq.offer(new int[] { dist[i], speed[i] });
        }
        int t = 1;
        pq.remove();
        while (!pq.isEmpty()) {
            final int[] remove = pq.remove();
            if (remove[0] - remove[1] * t <= 0) {
                break;
            }
            t++;
        }
        return t;
    }
}
