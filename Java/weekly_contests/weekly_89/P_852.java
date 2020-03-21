package weekly_contests.weekly_89;

public class P_852 {

    /* Binary search O(logN)
     * Faster than binary search?
     * https://en.wikipedia.org/wiki/Golden-section_search
     * https://en.wikipedia.org/wiki/Fibonacci_search_technique
     */
    @SuppressWarnings("MethodParameterNamingConvention")
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (A[mid] < A[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
