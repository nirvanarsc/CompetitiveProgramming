package weekly_contests.weekly_188;

public class P_1444 {

    private static final int MOD = (int) (1e9 + 7);

    public int ways(String[] pizza, int k) {
        final int n = pizza.length;
        final int m = pizza[0].length();
        final int[][] prefixSum = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                final int apple = pizza[i].charAt(j) == 'A' ? 1 : 0;
                prefixSum[i][j] = apple + prefixSum[i + 1][j] + prefixSum[i][j + 1] - prefixSum[i + 1][j + 1];
            }
        }
        return recurse(n, m, 0, 0, k - 1, prefixSum, new Integer[n][m][k]);
    }

    private static int recurse(int n, int m, int r, int c, int k, int[][] prefixSum, Integer[][][] dp) {
        if (k == 0 && prefixSum[r][c] > 0) {
            return 1;
        }
        if (dp[r][c][k] != null) {
            return dp[r][c][k];
        }
        int horizontal = 0;
        int vertical = 0;
        for (int row = r; row < n - 1; row++) {
            if (sumRegion(prefixSum, r, c, row, m - 1) > 0) {
                horizontal = (horizontal + recurse(n, m, row + 1, c, k - 1, prefixSum, dp)) % MOD;
            }
        }
        for (int col = c; col < m - 1; col++) {
            if (sumRegion(prefixSum, r, c, n - 1, col) > 0) {
                vertical = (vertical + recurse(n, m, r, col + 1, k - 1, prefixSum, dp)) % MOD;
            }
        }
        return dp[r][c][k] = (horizontal + vertical) % MOD;
    }

    public static int sumRegion(int[][] prefixSum, int r1, int c1, int r2, int c2) {
        return prefixSum[r1][c1] - prefixSum[r1][c2 + 1] - prefixSum[r2 + 1][c1] + prefixSum[r2 + 1][c2 + 1];
    }
}
