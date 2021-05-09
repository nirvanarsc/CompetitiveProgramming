package leetcode.weekly_contests.weekly_176;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1354 {

    public boolean isPossible(int[] target) {
        final int n = target.length;
        long sum = 0;
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : target) {
            sum += num;
            pq.add(num);
        }
        while (sum > n) {
            int max = pq.remove();
            final long other = sum - max;
            if (other >= max || other == 0) {
                return false;
            }
            if (max % other == 0 && other != 1) {
                return false;
            }
            max %= other;
            pq.add(max);
            sum = other + max;
        }
        return true;
    }
}
