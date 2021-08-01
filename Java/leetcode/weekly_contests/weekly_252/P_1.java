package leetcode.weekly_contests.weekly_252;

public class P_1 {

    public boolean isThree(int n) {
        final int sqrt = (int) Math.sqrt(n);
        return n > 1 && sqrt * sqrt == n && isPrime(sqrt);
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n > 1;
    }
}
