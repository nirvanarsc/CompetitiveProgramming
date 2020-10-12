package leetcode.easy;

public final class P_70 {

    public int climbStairsBottomUp(int n) {
        int a = 0;
        int b = 1;

        for (int i = 1; i <= n; i++) {
            final int next = a + b;
            a = b;
            b = next;
        }

        return b;
    }

    public int climbStairs(int n) {
        return climbStairs(0, n, new Integer[n]);
    }

    private static int climbStairs(int start, int n, Integer[] dp) {
        if (start == n) {
            return 1;
        }
        if (start > n) {
            return 0;
        }
        if (dp[start] != null) {
            return dp[start];
        }

        final int climbOne = climbStairs(start + 1, n, dp);
        final int climbTwo = climbStairs(start + 2, n, dp);
        return dp[start] = climbOne + climbTwo;
    }
}
