public final class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        final int n = matrix.length;
        final int m = matrix[0].length;
        final int[][] dp = new int[n][m];
        int res = 0;
        for (int r = 0; r < n; r++) {
            if (matrix[r][0] == '1') {
                dp[r][0] = 1;
                res = 1;
            }
        }

        for (int c = 0; c < m; c++) {
            if (matrix[0][c] == '1') {
                dp[0][c] = 1;
                res = 1;
            }
        }

        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                if (matrix[r][c] == '1') {
                    dp[r][c] = Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1])) + 1;
                    res = Math.max(res, dp[r][c]);
                }
            }
        }

        return res * res;
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][] {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' },
                }));
    }

    private MaximalSquare() {}
}
