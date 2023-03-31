package leetcode.weekly_contests.weekly_100_199.weekly_188;

public class P_1444 {

    private static final int MOD = (int) (1e9 + 7);

    static int n;
    static int m;
    static int[][] pre;
    static boolean[][][] seen;
    static int[][][] dp;

    public int ways(String[] pizza, int k) {
        n = pizza.length;
        m = pizza[0].length();
        pre = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                final int apple = pizza[i].charAt(j) == 'A' ? 1 : 0;
                pre[i][j] = apple + pre[i + 1][j] + pre[i][j + 1] - pre[i + 1][j + 1];
            }
        }
        seen = new boolean[n][m][k];
        dp = new int[n][m][k];
        return dfs(0, 0, k - 1);
    }

    private static int dfs(int r, int c, int k) {
        if (k == 0) {
            return pre[r][c] > 0 ? 1 : 0;
        }
        if (seen[r][c][k]) {
            return dp[r][c][k];
        }
        int horizontal = 0;
        int vertical = 0;
        for (int row = r; row < n - 1; row++) {
            if (sumRegion(r, c, row, m - 1) > 0) {
                horizontal = (horizontal + dfs(row + 1, c, k - 1)) % MOD;
            }
        }
        for (int col = c; col < m - 1; col++) {
            if (sumRegion(r, c, n - 1, col) > 0) {
                vertical = (vertical + dfs(r, col + 1, k - 1)) % MOD;
            }
        }
        seen[r][c][k] = true;
        return dp[r][c][k] = (horizontal + vertical) % MOD;
    }

    public static int sumRegion(int r1, int c1, int r2, int c2) {
        return pre[r1][c1] - pre[r1][c2 + 1] - pre[r2 + 1][c1] + pre[r2 + 1][c2 + 1];
    }
}
