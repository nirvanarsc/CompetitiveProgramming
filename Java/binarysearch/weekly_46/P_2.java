package binarysearch.weekly_46;

public class P_2 {

    public int solve(int[] ribbons, int k) {
        int lo = 0;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (f(ribbons, k, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo == 0 ? -1 : lo;
    }

    private static boolean f(int[] ribbons, int k, int mid) {
        int cuts = 0;
        for (int num : ribbons) {
            cuts += num / mid;
        }
        return cuts >= k;
    }
}
