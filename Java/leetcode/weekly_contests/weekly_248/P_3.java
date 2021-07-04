package leetcode.weekly_contests.weekly_248;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int countGoodNumbers(long n) {
        final long odd = (n + 1) / 2;
        final long even = n / 2;

        final long o = modPow(5, odd);
        final long e = modPow(4, even);

        final long res = (o * e) % MOD;

        return (int) res;
    }

    private static long modPow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            n /= 2;
        }
        return res;
    }
}
