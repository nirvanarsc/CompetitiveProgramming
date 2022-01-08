package leetcode.biweekly_contests.biweekly_27;

public class P_1463 {

    static int n;
    static int m;
    static int[][][] dp;
    static boolean[][][] seen;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][m];
        seen = new boolean[n][m][m];
        return dfs(grid, 0, 0, m - 1);
    }

    private static int dfs(int[][] g, int r, int c1, int c2) {
        if (r == n) {
            return 0;
        }
        if (seen[r][c1][c2]) {
            return dp[r][c1][c2];
        }
        int res = 0;
        final int t = c1 == c2 ? g[r][c1] : g[r][c1] + g[r][c2];
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                final int nc1 = c1 + i;
                final int nc2 = c2 + j;
                if (0 <= nc1 && nc1 < m && 0 <= nc2 && nc2 < m) {
                    res = Math.max(res, t + dfs(g, r + 1, nc1, nc2));
                }
            }
        }
        seen[r][c1][c2] = true;
        return dp[r][c1][c2] = res;
    }
}
