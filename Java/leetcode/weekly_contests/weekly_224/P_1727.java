package leetcode.weekly_contests.weekly_224;

import java.util.Arrays;

public class P_1727 {

    public int largestSubmatrix(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        int res = 0;
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = 0; j < m; j++) {
                res = Math.max(res, row[j] * (m - j));
            }
        }
        return res;
    }
}
