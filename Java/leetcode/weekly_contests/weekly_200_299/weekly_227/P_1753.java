package leetcode.weekly_contests.weekly_200_299.weekly_227;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1753 {

    public int maximumScore(int a, int b, int c) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);
        int res = 0;
        while (pq.size() > 1) {
            final Integer l = pq.remove();
            final Integer r = pq.remove();
            res++;
            if (l > 1) {
                pq.add(l - 1);
            }
            if (r > 1) {
                pq.add(r - 1);
            }
        }
        return res;
    }
}
