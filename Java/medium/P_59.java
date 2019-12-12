package medium;

import java.util.Arrays;

public final class P_59 {

    public static int[][] generateMatrix(int n) {
        final int[][] matrix = new int[n][n];
        final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        final int[] range = { n, n - 1 };
        int row = 0, col = -1, t = 1, dir = 0;
        while (range[dir % 2] > 0) {
            for (int i = 0; i < range[dir % 2]; i++) {
                row += dirs[dir][0];
                col += dirs[dir][1];
                matrix[row][col] = t++;
            }
            range[dir % 2] -= 1;
            dir = (dir + 1) % 4;
        }
        return matrix;
    }

    public static void main(String[] args) {
        for (int[] d : generateMatrix(5)) {
            System.out.println(Arrays.toString(d));
        }
    }

    private P_59() {}
}
