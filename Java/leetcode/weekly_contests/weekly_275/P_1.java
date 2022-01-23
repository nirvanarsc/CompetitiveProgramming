package leetcode.weekly_contests.weekly_275;

public class P_1 {

    public boolean checkValid(int[][] matrix) {
        final int n = matrix.length;
        for (int i = 0; i < n; i++) {
            final boolean[] row = new boolean[n];
            final boolean[] col = new boolean[n];
            for (int j = 0; j < n; j++) {
                final int r = matrix[i][j] - 1;
                final int c = matrix[j][i] - 1;
                if (row[r] || col[c]) {
                    return false;
                }
                row[r] = true;
                col[c] = true;
            }
        }
        return true;
    }
}
