package binarysearch.weekly_55;

public class P_3 {

    public int solve(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        final int[][][] dp = new int[n][m][3];
        for (int[][] row : dp) {
            for (int i = 0; i < m; i++) {
                row[i][0] = row[i][1] = row[i][2] = -1;
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, dfs(matrix, 0, i, 0, dp));
        }
        return res;
    }

    private static int dfs(int[][] mat, int r, int c, int dir, int[][][] dp) {
        if (r == mat.length) {
            return 0;
        }
        if (mat[r][c] == 1) {
            return (int) -1e9;
        }
        if (dp[r][c][dir + 1] != -1) {
            return dp[r][c][dir + 1];
        }
        int res = (int) -1e9;
        if (dir == 0) {
            res = Math.max(res, dfs(mat, r, c, -1, dp));
            res = Math.max(res, dfs(mat, r, c, 1, dp));
        } else {
            res = Math.max(res, 1 + dfs(mat, r + 1, c, 0, dp));
            if (0 <= c + dir && c + dir < mat[r].length) {
                res = Math.max(res, 1 + dfs(mat, r, c + dir, dir, dp));
            }
        }
        return dp[r][c][dir + 1] = res;
    }
}
