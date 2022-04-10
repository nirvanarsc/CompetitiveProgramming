package leetcode.weekly_contests.weekly_288;

import java.util.Arrays;

public class P_4 {

    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        Arrays.sort(flowers);
        final int n = flowers.length;
        if (flowers[0] == target) {
            return (long) full * n;
        }
        final long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + flowers[i - 1];
        }
        long curr = 0;
        long res = 0;
        for (int i = n; i >= 0; i--) {
            curr += i == n ? 0 : Math.max(0, target - flowers[i]);
            if (curr > newFlowers) {
                break;
            }
            final long rem = newFlowers - curr;
            int lo = 0;
            int hi = target - 1;
            while (lo < hi) {
                final int mid = lo + hi + 1 >>> 1;
                final int idx = lowerBound(flowers, mid, i);
                if ((long) idx * mid - pre[idx] > rem) {
                    hi = mid - 1;
                } else {
                    res = Math.max(res, (i > 0 ? ((long) mid * partial) : 0) + (long) full * (n - i));
                    lo = mid;
                }
            }
        }
        return res;
    }

    private static int lowerBound(int[] flowers, int mid, int to) {
        int lo = 0;
        int hi = to;
        while (lo < hi) {
            final int mid1 = lo + hi >>> 1;
            if (flowers[mid1] < mid) {
                lo = mid1 + 1;
            } else {
                hi = mid1;
            }
        }
        return lo;
    }
}
