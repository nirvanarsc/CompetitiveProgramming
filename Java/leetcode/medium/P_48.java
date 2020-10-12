package leetcode.medium;

import java.util.Arrays;

public final class P_48 {

    public static void rotate(int[][] matrix) {
        final int n = matrix.length - 1;
        for (int layer = 0; layer <= n / 2; layer++) {
            for (int i = layer; i < n - layer; i++) {
                final int temp = matrix[layer][i];
                matrix[layer][i] = matrix[n - i][layer];
                matrix[n - i][layer] = matrix[n - layer][n - i];
                matrix[n - layer][n - i] = matrix[i][n - layer];
                matrix[i][n - layer] = temp;
            }
        }
    }

    public static void main(String[] args) {
        final int[][] matrix = {
                { 1, 2, 3, 4, },
                { 5, 6, 7, 8, },
                { 9, 10, 11, 12, },
                { 13, 14, 15, 16, },
                };
        rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private P_48() {}
}
