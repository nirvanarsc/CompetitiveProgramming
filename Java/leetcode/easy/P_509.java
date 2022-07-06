package leetcode.easy;

public final class P_509 {

    public int fib(int n) {
        final int[] dp = { 0, 1 };
        for (int i = 0; i < n; i++) {
            final int next = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = next;
        }
        return dp[0];
    }

    // https://en.wikipedia.org/wiki/Fibonacci_number#Closed-form_expression
    public int fibClosedForm(int n) {
        final double sqrt5 = 2.23606797749979;
        final double goldenRatio = (1 + sqrt5) / 2;
        return (int) Math.round(Math.pow(goldenRatio, n) / sqrt5);
    }
}
