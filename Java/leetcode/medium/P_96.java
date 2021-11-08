package leetcode.medium;

public final class P_96 {

    public int numTreesBottomUp(int n) {
        final int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public int numTreesTopDown(int n) {
        return dfs(1, n, new Integer[n + 1][n + 1]);
    }

    private static int dfs(int lo, int hi, Integer[][] dp) {
        if (lo >= hi) {
            return 1;
        }
        if (dp[lo][hi] != null) {
            return dp[lo][hi];
        }
        int total = 0;
        for (int i = lo; i <= hi; i++) {
            total += dfs(lo, i - 1, dp) * dfs(i + 1, hi, dp);
        }
        return dp[lo][hi] = total;
    }

    // https://en.wikipedia.org/wiki/Catalan_number
    // 2n choose n / (n + 1)
    public int numTreesCatalan(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

    static boolean init;
    static long[][] dp;

    public int numTrees(int n) {
        if (!init) {
            init = true;
            dp = f();
        }
        return (int) (dp[2 * n][n] / (n + 1));
    }

    private static long[][] f() {
        final int n = 40;
        final long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp;
    }
}
