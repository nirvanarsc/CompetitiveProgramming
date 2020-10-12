package leetcode.weekly_contests.smarking_2;

public class P_441 {

    // upperBound
    public int arrangeCoins(int n) {
        long lo = 0;
        long hi = n;
        while (lo < hi) {
            final long mid = (1 + lo + hi) >>> 1;
            if (mid * (mid + 1) / 2 <= n) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return (int) lo;
    }

    public int arrangeCoinsMath(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }
}
