package leetcode.medium;

public final class P_48 {

    public void rotate(int[][] matrix) {
        final int n = matrix.length;
        for (int level = 0; level < n / 2; level++) {
            for (int i = level; i < (n - 1 - level); i++) {
                final int[] d = { level, i, n - 1 - level, n - 1 - i };
                final int[] curr = new int[4];
                for (int j = 0; j < 4; j++) {
                    final int r = d[j];
                    final int c = d[(j + 1) % 4];
                    curr[j] = matrix[r][c];
                }
                for (int j = 0; j < 4; j++) {
                    final int r = d[j];
                    final int c = d[(j + 1) % 4];
                    matrix[r][c] = curr[(j + 3) % 4];
                }
            }
        }
    }
}
