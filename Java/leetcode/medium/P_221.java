package leetcode.medium;

public class P_221 {

    public int maximalSquare(char[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        final int[][] dp = new int[n + 1][m + 1];
        int res = 0;
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                if (matrix[r - 1][c - 1] == '1') {
                    dp[r][c] = Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1])) + 1;
                    res = Math.max(res, dp[r][c] * dp[r][c]);
                }
            }
        }
        return res;
    }
}
