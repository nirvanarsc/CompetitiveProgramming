package leetcode.weekly_contests.weekly_200_299.weekly_221;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1705 {

    public int eatenApples(int[] apples, int[] days) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(val -> val[0]));
        int res = 0;
        for (int i = 0; i < 1e5; i++) {
            if (i < apples.length) {
                pq.add(new int[] { i + days[i] - 1, apples[i] });
            }
            while (!pq.isEmpty() && pq.element()[0] < i) {
                pq.remove();
            }
            if (!pq.isEmpty()) {
                final int[] curr = pq.remove();
                curr[1]--;
                res++;
                if (curr[1] > 0) {
                    pq.add(curr);
                }
            }
        }
        return res;
    }
}
