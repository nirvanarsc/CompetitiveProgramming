package leetcode.weekly_contests.weekly_0_99.smarking_2;

public class P_441 {

    public int arrangeCoins(int n) {
        long lo = 0;
        long hi = (long) 1e5;
        while (lo < hi) {
            final long mid = lo + hi + 1 >>> 1;
            if (((mid * (mid + 1)) / 2) > n) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return (int) lo;
    }

    public int arrangeCoinsMath(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }
}
