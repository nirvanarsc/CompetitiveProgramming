package leetcode.biweekly_contests.biweekly_99;

import java.util.PriorityQueue;

public class P_1 {

    public int splitNum(int num) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (num > 0) {
            pq.offer(num % 10);
            num /= 10;
        }
        int l = 0;
        int r = 0;
        for (int i = 0; !pq.isEmpty(); i++) {
            if (i % 2 == 0) {
                l = (l * 10) + pq.remove();
            } else {
                r = (r * 10) + pq.remove();
            }
        }
        return l + r;
    }
}
