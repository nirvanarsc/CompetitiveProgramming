package leetcode.weekly_contests.weekly_137;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1046 {

    public int lastStoneWeight(int[] stones) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() >= 2) {
            final Integer first = pq.remove();
            final Integer second = pq.remove();
            if (!first.equals(second)) {
                pq.add(first - second);
            }
        }
        return pq.isEmpty() ? 0 : pq.remove();
    }
}
