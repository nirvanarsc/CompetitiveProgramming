package medium;

public class P_275 {

    public int hIndex(int[] citations) {
        final int n = citations.length;
        int lo = 0, hi = n;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (citations[mid] < n - mid) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return n - lo;
    }
}
