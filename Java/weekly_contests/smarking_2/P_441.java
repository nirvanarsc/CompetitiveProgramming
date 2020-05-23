package weekly_contests.smarking_2;

public class P_441 {

    public int arrangeCoins(int n) {
        long lo = 1;
        long hi = (long) n * 2;
        while (lo < hi) {
            final long mid = lo + hi >>> 1;
            if (mid * (mid + 1) / 2 <= n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return (int) lo - 1;
    }
}
