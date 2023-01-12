package leetcode.biweekly_contests.biweekly_95;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_4 {

    public long maxPower(int[] stations, int r, int k) {
        final int n = stations.length;
        final long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + stations[i - 1];
        }
        final long[] p = new long[n];
        long lo = (long) 1e14;
        long hi = (long) 1e14;
        for (int i = 0; i < n; i++) {
            p[i] = pre[Math.min(n, i + r + 1)] - pre[Math.max(0, i - r)];
            lo = Math.min(lo, p[i]);
        }
        while (lo < hi) {
            final long mid = lo + hi + 1 >>> 1;
            final Deque<long[]> dq = new ArrayDeque<>();
            long add = 0;
            long need = 0;
            for (int i = 0; i < n; i++) {
                while (!dq.isEmpty() && dq.getFirst()[0] < i) {
                    add -= dq.removeFirst()[1];
                }
                final long curr = p[i] + add;
                if (curr < mid) {
                    need += mid - curr;
                    add += mid - curr;
                    dq.addLast(new long[] { i + 2 * r, mid - curr });
                }
            }
            if (k < need) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
