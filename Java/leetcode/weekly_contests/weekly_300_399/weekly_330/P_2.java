package leetcode.weekly_contests.weekly_300_399.weekly_330;

public class P_2 {

    private static final int MOD = (int) 1e9 + 7;

    public int monkeyMove(int n) {
        final long p = modPow(2, n);
        return (int) ((p - 2 + MOD) % MOD);
    }

    private static long modPow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            n /= 2;
        }
        return res;
    }
}
