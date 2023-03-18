package leetcode.biweekly_contests.biweekly_0_99.biweekly_17;

public class P_1314 {

    // prefix range - similar to
    // https://leetcode.com/problems/range-sum-query-2d-immutable/
    // https://leetcode.com/problems/range-sum-query-mutable/
    // https://leetcode.com/problems/range-sum-query-2d-mutable/
    public int[][] matrixBlockSumPrefixRange(int[][] mat, int k) {
        final int m = mat.length;
        final int n = mat[0].length;
        final int[][] rangeSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                rangeSum[i + 1][j + 1] = rangeSum[i + 1][j] + rangeSum[i][j + 1] - rangeSum[i][j] + mat[i][j];
            }
        }
        final int[][] res = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                final int r1 = Math.max(0, i - k);
                final int c1 = Math.max(0, j - k);
                final int r2 = Math.min(m, i + k + 1);
                final int c2 = Math.min(n, j + k + 1);
                res[i][j] = rangeSum[r2][c2] + rangeSum[r1][c1] - rangeSum[r2][c1] - rangeSum[r1][c2];
            }
        }
        return res;
    }

    // brute force
    public int[][] matrixBlockSum(int[][] mat, int k) {
        final int n = mat.length;
        final int m = mat[0].length;
        final int[][] res = new int[n][m];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                for (int x = Math.max(0, i - k); x <= Math.min(mat.length - 1, i + k); x++) {
                    for (int y = Math.max(0, j - k); y <= Math.min(mat[0].length - 1, j + k); y++) {
                        res[i][j] += mat[x][y];
                    }
                }
            }
        }
        return res;
    }
}
