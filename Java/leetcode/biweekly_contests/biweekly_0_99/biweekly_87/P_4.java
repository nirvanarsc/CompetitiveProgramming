package leetcode.biweekly_contests.biweekly_0_99.biweekly_87;

import java.util.Arrays;

public class P_4 {

    public long minimumMoney(int[][] transactions) {
        Arrays.sort(transactions,
                    (a, b) -> f(a, b) == f(b, a) ? Integer.compare(b[0], a[0])
                                                 : Integer.compare(f(a, b), f(b, a)));
        long lo = 0;
        long hi = (long) 9e18;
        while (lo < hi) {
            final long mid = lo + hi >>> 1;
            if (!f(transactions, mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int f(int[] l, int[] r) {
        return Math.min(-l[0], -l[0] + l[1] - r[0]);
    }

    private static boolean f(int[][] t, long mid) {
        for (int[] tt : t) {
            if (tt[0] > mid) {
                return false;
            }
            mid = mid - tt[0] + tt[1];
        }
        return true;
    }
}
