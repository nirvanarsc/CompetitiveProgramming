package leetcode.weekly_contests.weekly_165;

public class P_1277 {

    public int countSquares(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        final int[][] dp = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 1) { dp[i][0] = 1; }
        }
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 1) { dp[0][j] = 1; }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { count += dp[i][j]; }
        }

        return count;
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
