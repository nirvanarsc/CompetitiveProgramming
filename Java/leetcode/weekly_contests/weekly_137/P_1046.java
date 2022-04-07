package leetcode.weekly_contests.weekly_137;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1046 {

    public int lastStoneWeight(int[] stones) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        pq.add(0);
        while (pq.size() > 1) {
            final int u = pq.remove();
            final int v = pq.remove();
            if (u > v) {
                pq.add(u - v);
            }
        }
        return pq.element();
    }
}
