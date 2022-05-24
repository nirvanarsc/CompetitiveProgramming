package leetcode.weekly_contests.weekly_200_299.weekly_252;

public class P_3 {

    public long minimumPerimeter(long neededApples) {
        long lo = 0;
        long hi = (long) 1e5;
        while (lo < hi) {
            final long mid = lo + hi >>> 1;
            if (f(mid) < neededApples) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return 8 * lo;
    }

    private static long f(long mid) {
        final long n = 2 * mid + 1;
        final long add = (mid * (mid + 1)) / 2;
        return 4 * add * n;
    }
}
