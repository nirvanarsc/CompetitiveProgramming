package hard;

public class P_308 {

    static class NumMatrix {
        int n, m;
        int[][] bit;
        int[][] original;

        NumMatrix(int[][] matrix) {
            if (matrix.length < 1) { return; }
            n = matrix.length;
            m = matrix[0].length;
            bit = new int[n + 1][m + 1];
            original = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }

        public void update(int row, int col, int val) {
            final int diff = val - original[row][col];
            original[row][col] = val;
            for (int i = row + 1; i <= n; i += lsb(i)) {
                for (int j = col + 1; j <= m; j += lsb(j)) {
                    bit[i][j] += diff;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum(row2, col2) + sum(row1 - 1, col1 - 1) - sum(row1 - 1, col2) - sum(row2, col1 - 1);
        }

        public int sum(int row, int col) {
            int res = 0;
            for (int i = row + 1; i > 0; i -= lsb(i)) {
                for (int j = col + 1; j > 0; j -= lsb(j)) {
                    res += bit[i][j];
                }
            }
            return res;
        }

        private static int lsb(int i) {
            return i & -i;
        }
    }
}
