package leetcode.weekly_contests.weekly_279;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_2 {

    public long smallestNumber(long num) {
        final PriorityQueue<Long> pq;
        final int neg = num < 0 ? -1 : 1;
        if (num < 0) {
            num *= -1;
            pq = new PriorityQueue<>(Comparator.reverseOrder());
        } else {
            pq = new PriorityQueue<>();
        }
        int zero = 0;
        while (num > 0) {
            if (num % 10 == 0) {
                zero++;
            } else {
                pq.add(num % 10);
            }
            num /= 10;
        }
        long res = 0;
        if (neg == -1) {
            while (!pq.isEmpty()) {
                res = res * 10 + pq.remove();
            }
            while (zero-- > 0) {
                res *= 10;
            }
        } else {
            res = pq.isEmpty() ? 0 : pq.remove();
            while (zero-- > 0) {
                res *= 10;
            }
            while (!pq.isEmpty()) {
                res = res * 10 + pq.remove();
            }
        }
        return res * neg;
    }
}
