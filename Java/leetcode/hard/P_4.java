package leetcode.hard;

public class P_4 {

    // log (2e6) * log(n * m)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int n = nums1.length + nums2.length;
        final int k1;
        final int k2;
        if (n % 2 == 0) {
            k1 = (n / 2) - 1;
            k2 = n / 2;
        } else {
            k1 = k2 = n / 2;
        }
        final int l = upperBound(nums1, nums2, k1);
        final int r = upperBound(nums1, nums2, k2);
        return 0.5 * (l + r);
    }

    private static int upperBound(int[] nums1, int[] nums2, int k) {
        int lo = (int) -1e6;
        int hi = (int) 1e6;
        while (lo < hi) {
            final int mid = lo + hi + 1 >> 1;
            if (lowerBound(nums1, mid) + lowerBound(nums2, mid) > k) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private static int lowerBound(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
