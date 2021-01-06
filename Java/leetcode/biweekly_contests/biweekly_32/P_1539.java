package leetcode.biweekly_contests.biweekly_32;

public class P_1539 {

    // lowerBound
    public int findKthPositive(int[] arr, int k) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            final int missing = getMissing(arr, mid);
            if (missing < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        // lo + k = (arr[lo-1] - (arr[lo-1] - (lo-1 + 1))) + k
        return lo == 0 ? k : (arr[lo - 1] - getMissing(arr, lo - 1) + k);
    }

    private static int getMissing(int[] arr, int mid) {
        return arr[mid] - (mid + 1);
    }
}
