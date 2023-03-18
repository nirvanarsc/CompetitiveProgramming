package leetcode.biweekly_contests.biweekly_0_99.biweekly_36;

public class P_1605 {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        final int n = rowSum.length;
        final int m = colSum.length;
        final int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            int curr = rowSum[i];
            for (int j = 0; j < m; j++) {
                final int min = Math.min(curr, colSum[j]);
                matrix[i][j] = min;
                colSum[j] -= min;
                curr -= min;
                if (curr == 0) {
                    break;
                }
            }
        }
        return matrix;
    }
}
