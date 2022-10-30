package leetcode.weekly_contests.weekly_300_399.weekly_317;

public class P_3 {

    public long makeIntegerBeautiful(long n, int target) {
        long res = 0;
        long p = 10;
        while (f(n) > target) {
            final long u = p - n % p;
            n += u;
            res += u;
            p *= 10;
        }
        return res;
    }

    private static int f(long n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
