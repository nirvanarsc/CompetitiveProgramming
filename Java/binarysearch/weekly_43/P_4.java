package binarysearch.weekly_43;

import java.util.Arrays;

public class P_4 {

    public int solve(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        long lo = (long) -5e18;
        long hi = (long) 5e18;
        final int[] rev = reverse(b, b.length);
        final long complement = (long) a.length * b.length - k - 1;
        while (lo < hi) {
            final long mid = lo + hi + 1 >> 1;
            if (f(a, b, rev, mid) > complement) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return (int) lo;
    }

    private static int[] reverse(int[] nums, int n) {
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[n - 1 - i] = nums[i];
        }
        return res;
    }

    private static long f(int[] a, int[] b, int[] revB, long mid) {
        long count = 0;
        for (int num : a) {
            final int[] search = num > 0 ? b : revB;
            int lo = 0;
            int hi = b.length;
            while (lo < hi) {
                final int m = lo + hi >>> 1;
                if ((long) num * search[m] < mid) {
                    lo = m + 1;
                } else {
                    hi = m;
                }
            }
            count += lo;
        }
        return count;
    }
}
