package leetcode.biweekly_contests.biweekly_32;

public class P_1539 {

    public int findKthPositive(int[] arr, int k) {
        int lo = 1;
        int hi = 2000;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            final int missing = mid - lowerBound(arr, mid);
            if (missing > k) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private static int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
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
