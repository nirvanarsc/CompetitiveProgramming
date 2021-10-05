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

    static boolean[] seen;
    static int[] dp;
    static int max;

    public int climbStairs(int n) {
        max = n;
        seen = new boolean[n];
        dp = new int[n];
        return dfs(0);
    }

    private static int dfs(int curr) {
        if (curr >= max) {
            return curr == max ? 1 : 0;
        }
        if (seen[curr]) {
            return dp[curr];
        }
        seen[curr] = true;
        return dp[curr] = dfs(curr + 1) + dfs(curr + 2);
    }
}
