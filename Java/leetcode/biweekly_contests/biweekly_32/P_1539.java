package leetcode.biweekly_contests.biweekly_32;

public class P_1539 {

    // upperBound
    public int findKthPositive(int[] arr, int k) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            final int mid = (1 + lo + hi) >>> 1;
            if (mid == 0 || arr[mid - 1] - mid < k) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo + k;
    }
}
