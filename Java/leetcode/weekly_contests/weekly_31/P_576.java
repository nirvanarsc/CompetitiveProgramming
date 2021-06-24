package leetcode.weekly_contests.weekly_31;

public class P_576 {

    private static final int MOD = (int) (1e9 + 7);
    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    static int[][][] dp;
    static boolean[][][] seen;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove + 1];
        seen = new boolean[m][n][maxMove + 1];
        return dfs(startRow, startColumn, maxMove, m, n);
    }

    private static int dfs(int r, int c, int d, int n, int m) {
        if (r < 0 || r == n || c < 0 || c == m) {
            return 1;
        }
        if (d == 0) {
            return 0;
        }
        if (seen[r][c][d]) {
            return dp[r][c][d];
        }
        int res = 0;
        for (int[] dir : DIRS) {
            res = (res + dfs(r + dir[0], c + dir[1], d - 1, n, m)) % MOD;
        }
        seen[r][c][d] = true;
        return dp[r][c][d] = res;
    }
}
