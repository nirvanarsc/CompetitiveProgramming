package leetcode.weekly_contests.weekly_200_299.weekly_295;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_4 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minimumObstacles(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] d = new int[n][m];
        for (int[] row : d) {
            Arrays.fill(row, (int) 1e9);
        }
        final PriorityQueue<int[]> dq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        dq.add(new int[] { 0, 0, grid[0][0] });
        d[0][0] = grid[0][0];
        while (!dq.isEmpty()) {
            final int[] curr = dq.remove();
            final int x = curr[0];
            final int y = curr[1];
            final int w = curr[2];
            if (d[x][y] < w) {
                continue;
            }
            for (int[] dir : DIRS) {
                final int nx = x + dir[0];
                final int ny = y + dir[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (d[nx][ny] > d[x][y] + grid[nx][ny]) {
                        d[nx][ny] = d[x][y] + grid[nx][ny];
                        dq.offer(new int[] { nx, ny, d[nx][ny] });
                    }
                }
            }
        }
        return d[n - 1][m - 1];
    }
}
