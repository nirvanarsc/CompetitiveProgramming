public final class PeakIndexMountainArray {

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[] { 0, 1, 0 }));
        System.out.println(peakIndexInMountainArray(new int[] { 0, 2, 1, 0 }));
        System.out.println(peakIndexInMountainArray2(new int[] { 0, 1, 0 }));
        System.out.println(peakIndexInMountainArray2(new int[] { 0, 2, 1, 0 }));
    }

    // O(N)
    public static int peakIndexInMountainArray(int[] a) {
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                res = i;
            }
        }

        return res;
    }

    // Binary search O(logN)
    public static int peakIndexInMountainArray2(int[] a) {
        int l = 0, r = a.length - 1, m;
        while (l < r) {
            m = (l + r) / 2;
            if (a[m] < a[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    /* Faster than binary search?
     * https://en.wikipedia.org/wiki/Golden-section_search
     * https://en.wikipedia.org/wiki/Fibonacci_search_technique
     */

    private PeakIndexMountainArray() {}
}
