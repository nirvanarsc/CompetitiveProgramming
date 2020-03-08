package weekly_contests.weekly_179;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1375 {

    public int numTimesAllBlue(int[] light) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int res = 0;
        for (int num : light) {
            pq.add(num);
            if (pq.size() == pq.element()) {
                res++;
            }
        }
        return res;
    }
}
