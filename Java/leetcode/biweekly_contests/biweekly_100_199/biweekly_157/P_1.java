package leetcode.biweekly_contests.biweekly_100_199.biweekly_157;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class P_1 {

    public long sumOfLargestPrimes(String s) {
        final int n = s.length();
        final PriorityQueue<Long> pq = new PriorityQueue<>();
        final Set<Long> seen = new HashSet<>();
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                final long u = Long.parseLong(s.substring(i, j));
                if (f(u) && seen.add(u)) {
                    pq.add(u);
                    res += u;
                    if (pq.size() > 3) {
                        res -= pq.remove();
                    }
                }
            }
        }
        return res;
    }

    private static boolean f(long n) {
        for (int p = 2; (long) p * p <= n; p++) {
            if (n % p == 0) {
                return false;
            }
        }
        return n > 1;
    }
}
