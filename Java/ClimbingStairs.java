public final class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs2(2));
    }

    public static int climbStairs(int n) {
        if (n < 2) {
            return n;
        }

        int a = 0;
        int b = 1;

        for (int i = 1; i <= n; i++) {
            final int next = a + b;
            a = b;
            b = next;
        }

        return b;
    }

    public static int climbStairs2(int n) {
        return climbStairs(n, new int[n + 1]);
    }

    private static int climbStairs(int n, int[] memo) {
        if (n < 2) {
            return n;
        }

        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (memo[i] == 0) {
                memo[i] = memo[i - 1] + memo[i - 2];
            }
        }

        return memo[n] + memo[n - 1];
    }

    private ClimbingStairs() {}
}
