package leetcode.biweekly_contests.biweekly_71;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1 {

    public int minimumSum(int num) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while (num > 0) {
            if (num % 10 > 0) {
                pq.add(num % 10);
            }
            num /= 10;
        }
        int c = 0;
        int res = 0;
        while (!pq.isEmpty()) {
            final int pop = pq.remove();
            res += c > 1 ? 10 * pop : pop;
            c++;
        }
        return res;
    }
}
