package medium;

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

    public int numTrees(int n) {
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
    public int numTreesCatalan(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
