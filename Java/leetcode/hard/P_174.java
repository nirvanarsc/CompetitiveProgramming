package leetcode.hard;

public class P_174 {

    static int n;
    static int m;
    static int[][] dp;
    static boolean[][] seen;

    public int calculateMinimumHP(int[][] dungeon) {
        n = dungeon.length;
        m = dungeon[0].length;
        dp = new int[n][m];
        seen = new boolean[n][m];
        return 1 + dfs(dungeon, 0, 0);
    }

    private static int dfs(int[][] d, int r, int c) {
        if (r == n - 1 && c == m - 1) {
            return Math.max(0, -d[r][c]);
        }
        if (seen[r][c]) {
            return dp[r][c];
        }
        int res = (int) 1e9;
        if (r < n - 1) {
            res = Math.min(res, Math.max(0, -d[r][c] + dfs(d, r + 1, c)));
        }
        if (c < m - 1) {
            res = Math.min(res, Math.max(0, -d[r][c] + dfs(d, r, c + 1)));
        }
        seen[r][c] = true;
        return dp[r][c] = res;
    }
}
