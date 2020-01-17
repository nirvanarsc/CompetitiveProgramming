package easy;

public class P_766 {

    public boolean isToeplitzMatrixImproved(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int[] prev = matrix[0];
        for (int i = 1; i < matrix.length; i++) {
            if (!checkRows(prev, matrix[i])) {
                return false;
            }
            prev = matrix[i];
        }
        return true;
    }

    public boolean checkRows(int[] prev, int[] curr) {
        for (int i = 0; i < prev.length - 1; i++) {
            if (prev[i] != curr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
