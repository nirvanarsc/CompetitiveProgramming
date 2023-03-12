package leetcode.weekly_contests.weekly_300_399.weekly_336;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_2 {

    public int maxScore(int[] nums) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int res = 0;
        long sum = 0;
        for (int num : nums) {
            if (num > 0) {
                sum += num;
                res++;
            } else {
                pq.offer(num);
            }
        }
        while (!pq.isEmpty()) {
            sum += pq.remove();
            if (sum <= 0) {
                break;
            }
            res++;
        }
        return res;
    }
}
