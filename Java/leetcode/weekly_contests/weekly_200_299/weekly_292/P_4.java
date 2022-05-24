package leetcode.weekly_contests.weekly_200_299.weekly_292;

public class P_4 {

    static int n;
    static int m;
    static boolean[][][] seen;
    static int[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        if (grid[n - 1][m - 1] == '(' || grid[0][0] == ')') {
            return false;
        }
        seen = new boolean[n][m][n + m + 5];
        dp = new int[n][m][n + m + 5];
        return dfs(grid, 0, 0, 1) == 1;
    }

    private static int dfs(char[][] g, int i, int j, int op) {
        if (i == n - 1 && j == m - 1) {
            return op == 0 ? 1 : 0;
        }
        if (seen[i][j][op]) {
            return dp[i][j][op];
        }
        int res = 0;
        if (j < (m - 1)) {
            if (g[i][j + 1] == ')' && op > 0) {
                res = Math.max(res, dfs(g, i, j + 1, op - 1));
            } else if (g[i][j + 1] == '(') {
                res = Math.max(res, dfs(g, i, j + 1, op + 1));
            }
        }
        if (i < (n - 1)) {
            if (g[i + 1][j] == ')' && op > 0) {
                res = Math.max(res, dfs(g, i + 1, j, op - 1));
            } else if (g[i + 1][j] == '(') {
                res = Math.max(res, dfs(g, i + 1, j, op + 1));
            }
        }
        seen[i][j][op] = true;
        return dp[i][j][op] = res;
    }
}
