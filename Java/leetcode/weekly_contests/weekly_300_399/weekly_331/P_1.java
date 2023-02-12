package leetcode.weekly_contests.weekly_300_399.weekly_331;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1 {

    public long pickGifts(int[] gifts, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int gift : gifts) {
            pq.add(gift);
        }
        for (int i = 0; i < k; i++) {
            final int pop = pq.remove();
            final int floor = (int) Math.sqrt(pop);
            pq.add(floor);
        }
        long res = 0;
        while (!pq.isEmpty()) {
            res += pq.remove();
        }
        return res;
    }
}
