package leetcode.medium;

public class P_74 {

    // O(log n * m)
    public boolean searchMatrixBS(int[][] matrix, int target) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        int lo = 0;
        int hi = n * m - 1;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (matrix[mid / m][mid % m] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return matrix[lo / m][lo % m] == target;
    }

    // O(n + m)
    public boolean searchMatrix(int[][] matrix, int target) {
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
