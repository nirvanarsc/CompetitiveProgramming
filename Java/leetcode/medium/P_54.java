package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public final class P_54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        final int m = matrix.length;
        final int n = matrix[0].length;
        final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        final int[] range = { n, m - 1 };
        int dir = 0, row = 0, col = -1;
        while (range[dir % 2] != 0) {
            for (int i = 0; i < range[dir % 2]; i++) {
                row += dirs[dir][0];
                col += dirs[dir][1];
                res.add(matrix[row][col]);
            }

            range[dir % 2] -= 1;
            dir = (dir + 1) % 4;
        }

        return res;
    }

    public static void main(String[] args) {
        final int[][] matrix = {
                { 1, 2, 3, 4, },
                { 5, 6, 7, 8, },
                { 9, 10, 11, 12, },
                };
        System.out.println(spiralOrder(matrix));
    }

    private P_54() {}
}
