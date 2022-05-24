package leetcode.weekly_contests.weekly_200_299.weekly_266;

public class P_3 {

    public int minimizedMaximum(int n, int[] quantities) {
        long lo = 1;
        long hi = (long) 1e10;
        while (lo < hi) {
            final long mid = lo + hi >>> 1;
            long curr = 0;
            for (int q : quantities) {
                curr += (q + mid - 1) / mid;
            }
            if (curr > n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return (int) lo;
    }
}
