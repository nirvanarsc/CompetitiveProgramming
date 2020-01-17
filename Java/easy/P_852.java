package easy;

public class P_852 {

    /* Binary search O(logN)
     * Faster than binary search?
     * https://en.wikipedia.org/wiki/Golden-section_search
     * https://en.wikipedia.org/wiki/Fibonacci_search_technique
     */
    public int peakIndexInMountainArray(int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            final int mid = start + end >>> 1;
            if (a[mid] < a[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
