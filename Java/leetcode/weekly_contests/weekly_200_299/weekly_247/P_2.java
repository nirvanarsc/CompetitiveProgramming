package leetcode.weekly_contests.weekly_200_299.weekly_247;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_2 {

    public int[][] rotateGrid(int[][] grid, int k) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] res = new int[n][m];
        for (int i = 0; i < Math.min(n, m) / 2; i++) {
            final List<Integer> curr = new ArrayList<>();
            for (int j = i; j < m - i - 1; j++) {
                curr.add(grid[i][j]);
            }
            for (int j = i; j < n - i - 1; j++) {
                curr.add(grid[j][m - i - 1]);
            }
            for (int j = i; j < m - i - 1; j++) {
                curr.add(grid[n - i - 1][m - j - 1]);
            }
            for (int j = i; j < n - i - 1; j++) {
                curr.add(grid[n - j - 1][i]);
            }
            final int rotate = k % curr.size();
            Collections.rotate(curr, curr.size() - rotate);
            int idx = 0;
            for (int j = i; j < m - i - 1; j++) {
                res[i][j] = curr.get(idx++);
            }
            for (int j = i; j < n - i - 1; j++) {
                res[j][m - i - 1] = curr.get(idx++);
            }
            for (int j = i; j < m - i - 1; j++) {
                res[n - i - 1][m - j - 1] = curr.get(idx++);
            }
            for (int j = i; j < n - i - 1; j++) {
                res[n - j - 1][i] = curr.get(idx++);
            }
        }
        return res;
    }
}
