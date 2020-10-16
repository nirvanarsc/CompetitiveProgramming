package leetcode.medium;

public class P_74 {

    // O(log n * log m)
    public boolean searchMatrixBS(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowL = 0;
        int rowH = matrix.length - 1;
        int colL = 0;
        int colH = matrix[0].length - 1;

        while (rowL <= rowH) {
            final int midR = (rowL + rowH) >>> 1;
            if (matrix[midR][colL] > target) {
                rowH = midR - 1;
            } else if (matrix[midR][colH] < target) {
                rowL = midR + 1;
            } else {
                while (colL <= colH) {
                    final int midC = (colL + colH) >>> 1;
                    if (matrix[midR][midC] == target) {
                        return true;
                    } else if (matrix[midR][midC] > target) {
                        colH = midC - 1;
                    } else {
                        colL = midC + 1;
                    }
                }
            }
        }

        return false;
    }

    // O(n + m)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        final int n = matrix.length;
        final int m = matrix[0].length;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (i < n - 1 && matrix[i + 1][j] <= target) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }
}
