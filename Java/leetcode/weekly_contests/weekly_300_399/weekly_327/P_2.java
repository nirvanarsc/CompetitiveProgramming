package leetcode.weekly_contests.weekly_300_399.weekly_327;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_2 {

    public long maxKelements(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        long res = 0;
        for (int i = 0; i < k; i++) {
            final int u = pq.remove();
            res += u;
            pq.offer((u + 2) / 3);
        }
        return res;
    }
}
