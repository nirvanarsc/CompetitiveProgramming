package leetcode.weekly_contests.weekly_163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        final int m = grid.length;
        final int n = grid[0].length;
        k %= m * n;
        reverse(grid, 0, m * n - 1);
        reverse(grid, 0, k - 1);
        reverse(grid, k, m * n - 1);
        return new ArrayList(Arrays.asList(grid));
    }

    private static void reverse(int[][] g, int i, int j) {
        final int n = g[0].length;
        while (i < j) {
            final int r1 = i / n;
            final int c1 = i % n;
            final int r2 = j / n;
            final int c2 = j % n;
            final int tmp = g[r1][c1];
            g[r1][c1] = g[r2][c2];
            g[r2][c2] = tmp;
            i++;
            j--;
        }
    }
}
