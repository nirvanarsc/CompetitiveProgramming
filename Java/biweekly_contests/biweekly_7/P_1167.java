package biweekly_contests.biweekly_7;

import java.util.PriorityQueue;

public class P_1167 {

    public int connectSticks(int[] sticks) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : sticks) {
            pq.add(s);
        }

        int res = 0;
        while (pq.size() > 1) {
            final Integer a = pq.remove();
            final Integer b = pq.remove();
            res += a + b;
            pq.add(a + b);
        }
        return res;
    }
}
