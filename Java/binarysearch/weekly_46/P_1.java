package binarysearch.weekly_46;

public class P_1 {

    public int solve(int[][] reviews, int threshold) {
        int x = 0;
        int y = 0;
        for (int[] r : reviews) {
            x += r[0];
            y += r[1];
        }
        int lo = 0;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            final long xx = (x + mid) * 100L;
            final long yy = (y + mid) * (long) threshold;
            if (xx < yy) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
