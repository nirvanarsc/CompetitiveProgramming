package leetcode.biweekly_contests.biweekly_0_99.biweekly_63;

public class P_4 {

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long lo = (long) -1e10;
        long hi = (long) 1e10;
        while (lo < hi) {
            final long mid = lo + hi + 1 >> 1;
            if (f(nums1, nums2, mid) < k) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private static long f(int[] nums1, int[] nums2, long mid) {
        long count = 0;
        for (int num : nums1) {
            int lo = 0;
            int hi = nums2.length;
            if (num < 0) {
                while (lo < hi) {
                    final int m = lo + hi >>> 1;
                    if ((long) nums2[m] * num >= mid) {
                        lo = m + 1;
                    } else {
                        hi = m;
                    }
                }
                count += nums2.length - lo;
            } else {
                while (lo < hi) {
                    final int m = lo + hi >>> 1;
                    if ((long) nums2[m] * num < mid) {
                        lo = m + 1;
                    } else {
                        hi = m;
                    }
                }
                count += lo;
            }
        }
        return count;
    }
}
