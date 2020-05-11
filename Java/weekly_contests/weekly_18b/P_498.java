package weekly_contests.weekly_18b;

import java.util.ArrayList;
import java.util.List;

public class P_498 {

    public static final int[] EMPTY = new int[0];

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return EMPTY;
        }
        final int n = matrix.length;
        final int m = matrix[0].length;
        final List<Integer> res = new ArrayList<>();
        boolean up = true;
        for (int i = 0; i < n; i++) {
            final List<Integer> curr = new ArrayList<>();
            int r = i;
            int c = 0;
            while (r >= 0 && r < n && c >= 0 && c < m) {
                if (up) {
                    curr.add(matrix[r][c]);
                } else {
                    curr.add(0, matrix[r][c]);
                }
                r--;
                c++;
            }
            res.addAll(curr);
            up ^= true;
        }
        for (int j = 1; j < m; j++) {
            final List<Integer> curr = new ArrayList<>();
            int r = n - 1;
            int c = j;
            while (r >= 0 && r < n && c >= 0 && c < m) {
                if (up) {
                    curr.add(matrix[r][c]);
                } else {
                    curr.add(0, matrix[r][c]);
                }
                r--;
                c++;
            }
            res.addAll(curr);
            up ^= true;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
