package leetcode.weekly_contests.weekly_200_299.weekly_234;

public class P_1808 {

    private static final int MOD = (int) (1e9 + 7);

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors < 5) {
            return primeFactors;
        }
        final int num2;
        if (primeFactors % 3 == 0) {
            num2 = 0;
        } else if (primeFactors % 3 == 1) {
            num2 = 2;
        } else {
            num2 = 1;
        }
        primeFactors -= num2 * 2;
        final int num3 = primeFactors / 3;
        final long p1 = modPow(3, num3);
        final long p2 = modPow(2, num2);

        return (int) ((p1 * p2) % MOD);
    }

    private static long modPow(long a, int n) {
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
