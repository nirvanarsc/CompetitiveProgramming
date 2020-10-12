package leetcode.medium;

public class P_73 {

    public void setZeroes(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        boolean firstRow = false, firstCol = false;

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
                nullifyRow(matrix, i);
            }
        }

        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                nullifyCol(matrix, j);
            }
        }

        if (firstRow) { nullifyRow(matrix, 0); }
        if (firstCol) { nullifyCol(matrix, 0); }
    }

    private static void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void nullifyCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
