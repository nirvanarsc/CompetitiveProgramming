package leetcode.weekly_contests.weekly_212;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1631 {

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int minimumEffortPath(int[][] heights) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        final int n = heights.length;
        final int m = heights[0].length;
        final int[][] d = new int[n][m];
        for (int[] row : d) {
            Arrays.fill(row, (int) 1e9);
        }
        d[0][0] = 0;
        pq.offer(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int x = curr[0];
            final int y = curr[1];
            final int v = curr[2];
            if (d[x][y] < v) {
                continue;
            }
            for (int[] dir : DIRS) {
                final int nx = x + dir[0];
                final int ny = y + dir[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (d[nx][ny] > Math.max(d[x][y], Math.abs(heights[x][y] - heights[nx][ny]))) {
                        d[nx][ny] = Math.max(d[x][y], Math.abs(heights[x][y] - heights[nx][ny]));
                        pq.offer(new int[] { nx, ny, d[nx][ny] });
                    }
                }
            }
        }
        return d[n - 1][m - 1];
    }
}
