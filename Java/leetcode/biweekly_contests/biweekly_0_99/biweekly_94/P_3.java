package leetcode.biweekly_contests.biweekly_0_99.biweekly_94;

public class P_3 {

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long lo = 0;
        long hi = (long) 9e18;
        final long lcm = lcm(divisor1, divisor2);
        while (lo < hi) {
            final long mid = lo + hi >>> 1;
            if (!f(mid, divisor1, divisor2, lcm, uniqueCnt1, uniqueCnt2)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return (int) lo;
    }

    private static boolean f(long m, long d1, long d2, long lcm, long c1, long c2) {
        final long notD1 = m - (m / d1);
        final long notD2 = m - (m / d2);
        final long D1UnionD2 = (m / d1) + (m / d2) - (m / lcm);
        final long notD1UnionD2 = m - D1UnionD2;
        return notD1UnionD2 >= Math.max(0, c1 - (notD1 - notD1UnionD2)) +
                               Math.max(0, c2 - (notD2 - notD1UnionD2));
    }
}
