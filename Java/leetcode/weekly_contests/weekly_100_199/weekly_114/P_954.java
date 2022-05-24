package leetcode.weekly_contests.weekly_100_199.weekly_114;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_954 {

    public boolean canReorderDoubled(int[] arr) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(Math::abs));
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.merge(num, 1, Integer::sum);
            pq.offer(num);
        }
        while (!pq.isEmpty()) {
            final int num = pq.remove();
            if (!freq.containsKey(num)) {
                continue;
            }
            final int l = freq.merge(num, -1, Integer::sum);
            final int f = freq.merge(num * 2, -1, Integer::sum);
            if (f < 0) {
                return false;
            }
            if (f == 0) {
                freq.remove(num * 2);
            }
            if (l == 0) {
                freq.remove(num);
            }
        }
        return freq.isEmpty();
    }
}
