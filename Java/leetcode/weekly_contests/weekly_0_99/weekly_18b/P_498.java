package leetcode.weekly_contests.weekly_0_99.weekly_18b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_498 {

    public static final int[] EMPTY = new int[0];

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return EMPTY;
        }
        final int n = matrix.length;
        final int m = matrix[0].length;
        final int[] res = new int[n * m];
        int idx = 0;
        boolean reverse = false;
        for (int i = 0; i < n; i++, reverse ^= true) {
            idx = f(matrix, res, idx, i, 0, reverse);
        }
        for (int i = 1; i < m; i++, reverse ^= true) {
            idx = f(matrix, res, idx, n - 1, i, reverse);
        }
        return res;
    }

    private static int f(int[][] matrix, int[] res, int idx, int r, int c, boolean reverse) {
        final List<Integer> curr = new ArrayList<>();
        while (r >= 0 && c < matrix[r].length) {
            curr.add(matrix[r][c]);
            r--;
            c++;
        }
        if (reverse) {
            Collections.reverse(curr);
        }
        for (int num : curr) {
            res[idx++] = num;
        }
        return idx;
    }
}
