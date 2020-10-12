package leetcode.weekly_contests.weekly_176;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1354 {

    public boolean isPossible(int[] target) {
        final PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (int t : target) {
            pq.add((long) t);
            sum += t;
        }

        while (sum > target.length) {
            final long max = pq.remove();
            final long prev = 2 * max - sum;
            if (prev < 1) {
                return false;
            }
            pq.add(prev);
            sum -= max - prev;
        }

        return sum == target.length;
    }
}
