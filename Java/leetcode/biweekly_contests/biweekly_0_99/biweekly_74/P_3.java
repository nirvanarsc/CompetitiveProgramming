package leetcode.biweekly_contests.biweekly_0_99.biweekly_74;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_3 {

    public int halveArray(int[] nums) {
        final PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long s = 0;
        for (int num : nums) {
            pq.offer((double) num);
            s += num;
        }
        double t = s * 0.5;
        int res = 0;
        while (Double.compare(t, 0) > 0) {
            final double pop = pq.remove();
            t -= pop * 0.5;
            pq.offer(pop * 0.5);
            res++;
        }
        return res;
    }
}
