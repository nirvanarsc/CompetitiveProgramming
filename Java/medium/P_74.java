package medium;

public class P_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
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
}
