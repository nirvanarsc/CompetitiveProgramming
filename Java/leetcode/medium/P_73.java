package leetcode.medium;

public class P_73 {

    public void setZeroes(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                firstCol = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i, m);
            }
        }
        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                nullifyCol(matrix, j, n);
            }
        }
        if (firstRow) { nullifyRow(matrix, 0, m); }
        if (firstCol) { nullifyCol(matrix, 0, n); }
    }

    private static void nullifyRow(int[][] matrix, int row, int m) {
        for (int i = 0; i < m; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void nullifyCol(int[][] matrix, int col, int n) {
        for (int i = 0; i < n; i++) {
            matrix[i][col] = 0;
        }
    }
}
