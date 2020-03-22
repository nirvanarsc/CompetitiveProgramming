package biweekly_contests.biweekly_22;

import java.util.PriorityQueue;

public class P_1387 {

    static class Pair {
        int num;
        int pow;

        Pair(int num, int pow) {
            this.num = num;
            this.pow = pow;
        }
    }

    public int getKth(int lo, int hi, int k) {
        final PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.pow == b.pow
                                                                     ? Integer.compare(b.num, a.num)
                                                                     : Integer.compare(b.pow, a.pow));
        for (int t = lo; t <= hi; t++) {
            pq.offer(new Pair(t, getPow(t)));
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.remove().num;
    }

    private static int getPow(int num) {
        if (num == 1) {
            return 1;
        }
        if (num % 2 == 0) {
            return 1 + getPow(num >> 1);
        }
        return 1 + getPow(3 * num + 1);
    }
}
