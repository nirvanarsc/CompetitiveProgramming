package leetcode.hard;

public class P_174 {

    public int calculateMinimumHP(int[][] dungeon) {
        final int n = dungeon.length;
        final int m = dungeon[0].length;
        final int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return 1 + dfs(dungeon, 0, 0, n, m, dp);
    }

    private static int dfs(int[][] d, int r, int c, int n, int m, int[][] dp) {
        if (r == n - 1 && c == m - 1) {
            return Math.max(0, -d[r][c]);
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        int res = (int) 1e9;
        if (r < n - 1) {
            res = Math.min(res, Math.max(0, -d[r][c] + dfs(d, r + 1, c, n, m, dp)));
        }
        if (c < m - 1) {
            res = Math.min(res, Math.max(0, -d[r][c] + dfs(d, r, c + 1, n, m, dp)));
        }
        return dp[r][c] = res;
    }
}
