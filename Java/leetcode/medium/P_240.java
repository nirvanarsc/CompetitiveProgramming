package leetcode.medium;

public class P_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        int col = m - 1;
        int row = 0;
        while (col >= 0 && row < n) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
