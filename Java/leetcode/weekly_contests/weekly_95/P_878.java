package leetcode.weekly_contests.weekly_95;

public class P_878 {

    private static final int MOD = (int) (1e9 + 7);

    @SuppressWarnings("MethodParameterNamingConvention")
    public int nthMagicalNumber(int N, int A, int B) {
        long lo = 2, hi = (long) 1e14;
        final int gcd = gcd(A, B);
        final int lcm = A * B / gcd;
        while (lo < hi) {
            final long mid = lo + hi >>> 1;
            if (mid / A + mid / B - mid / lcm < N) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return (int) (lo % MOD);
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
