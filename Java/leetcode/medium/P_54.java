package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class P_54 {

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        final int m = matrix.length;
        final int n = matrix[0].length;
        final int[] range = { n, m - 1 };
        int dir = 0, row = 0, col = -1;
        while (range[dir % 2] != 0) {
            for (int i = 0; i < range[dir % 2]; i++) {
                row += DIRS[dir][0];
                col += DIRS[dir][1];
                res.add(matrix[row][col]);
            }
            range[dir % 2] -= 1;
            dir = (dir + 1) % 4;
        }
        return res;
    }
}
