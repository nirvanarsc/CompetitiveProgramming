package leetcode.weekly_contests.weekly_253;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_2 {

    public int minStoneSum(int[] piles, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int pile : piles) {
            sum += pile;
            pq.offer(pile);
        }
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            final int curr = pq.remove();
            sum -= curr / 2;
            pq.offer(curr - (curr / 2));
        }
        return sum;
    }
}
