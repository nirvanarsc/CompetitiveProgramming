package binarysearch.weekly_28;

public class P_3 {

    public int solve(int[] counts, int k) {
        int lo = 0;
        int hi = (int) 2e9;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (!f(counts, mid, k)) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private static boolean f(int[] counts, int mid, int k) {
        long c = 0;
        for (int cc : counts) {
            c += Math.min(cc, mid);
        }
        return (c / k) >= mid;
    }
}
