package leetcode.weekly_contests.weekly_95;

public class P_878 {

    private static final int MOD = (int) (1e9 + 7);

    public int nthMagicalNumber(int n, int a, int b) {
        long lo = 0;
        long hi = (long) 1e18;
        final int gcd = gcd(a, b);
        final int lcm = a * b / gcd;
        while (lo < hi) {
            final long mid = lo + hi >>> 1;
            final long curr = (mid / a + mid / b) - mid / lcm;
            if (curr < n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return (int) (lo % MOD);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
