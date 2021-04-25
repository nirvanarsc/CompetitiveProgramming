package leetcode.medium;

public final class P_48 {

    public void rotate(int[][] matrix) {
        final int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            for (int i = layer; i < (n - 1 - layer); i++) {
                final int topL = matrix[layer][i];
                final int topR = matrix[i][n - 1 - layer];
                final int botR = matrix[n - 1 - layer][n - 1 - i];
                final int botL = matrix[n - 1 - i][layer];
                matrix[layer][i] = botL;
                matrix[i][n - 1 - layer] = topL;
                matrix[n - 1 - layer][n - 1 - i] = topR;
                matrix[n - 1 - i][layer] = botR;
            }
        }
    }
}
