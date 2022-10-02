package leetcode.weekly_contests.weekly_300_399.weekly_313;

public class P_1 {

    public int commonFactors(int a, int b) {
        return f(gcd(a, b));
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int f(int n) {
        int res = 0;
        for (int p = 1; p * p <= n; p++) {
            if (n % p == 0) {
                res += p != n / p ? 2 : 1;
            }
        }
        return res;
    }
}
