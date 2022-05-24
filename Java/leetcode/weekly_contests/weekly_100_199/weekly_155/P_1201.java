package leetcode.weekly_contests.weekly_100_199.weekly_155;

public class P_1201 {

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private static int count(long a, long b, long c, long num) {
        return (int) ((num / a) + (num / b) + (num / c)
                      - (num / lcm(a, b))
                      - (num / lcm(b, c))
                      - (num / lcm(a, c))
                      + (num / lcm(a, lcm(b, c))));
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int lo = 1, hi = Integer.MAX_VALUE;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (count(a, b, c, mid) < n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
