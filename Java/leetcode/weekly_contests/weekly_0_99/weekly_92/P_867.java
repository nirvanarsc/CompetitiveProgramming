package leetcode.weekly_contests.weekly_0_99.weekly_92;

public class P_867 {

    public int[][] transpose(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        final int[][] res = new int[m][n];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
