package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class P_296 {

    public int minTotalDistance(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final List<Integer> rows = new ArrayList<>(m);
        final List<Integer> cols = new ArrayList<>(n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int[] ints : grid) {
                if (ints[j] == 1) {
                    cols.add(j);
                }
            }
        }
        return getMin(rows) + getMin(cols);
    }

    private static int getMin(List<Integer> list) {
        int res = 0;
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            res += list.get(j) - list.get(i);

        }
        return res;
    }
}
