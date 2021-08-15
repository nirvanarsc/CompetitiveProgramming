package leetcode.weekly_contests.weekly_254;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int minNonZeroProduct(int p) {
        final long pow = (1L << (p - 1)) - 1;
        final long max = ((1L << p) - 2) % MOD;
        final long maxx = ((1L << p) - 1) % MOD;
        long res = modPow(max, pow);
        res = (res * maxx) % MOD;
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
