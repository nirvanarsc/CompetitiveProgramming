package leetcode.medium;

public class P_378 {



    public int kthSmallest(int[][] matrix, int k) {
        final int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (countLessOrEqual(matrix, mid, n) < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int countLessOrEqual(int[][] matrix, int mid, int n) {
        int count = 0;
        int j = n - 1;
        int i = 0;
        while (i < n && j >= 0) {
            if (matrix[i][j] > mid) {
                j--;
            } else {
                count += j + 1;
                i++;
            }
        }
        return count;
    }
}
