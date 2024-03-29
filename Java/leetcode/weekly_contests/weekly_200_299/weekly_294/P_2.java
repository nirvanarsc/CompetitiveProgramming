package leetcode.weekly_contests.weekly_200_299.weekly_294;

import java.util.PriorityQueue;

public class P_2 {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int full = 0;
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        final int n = capacity.length;
        for (int i = 0; i < n; i++) {
            if (capacity[i] == rocks[i]) {
                full++;
            } else {
                pq.offer(capacity[i] - rocks[i]);
            }
        }
        while (!pq.isEmpty() && additionalRocks > 0) {
            int top = pq.remove();
            final int take = Math.min(top, additionalRocks);
            top -= take;
            additionalRocks -= take;
            if (top > 0) {
                break;
            } else {
                full++;
            }
        }
        return full;
    }
}
