package leetcode.weekly_contests.weekly_212;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1631 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minimumEffortPath(int[][] heights) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        final int n = heights.length;
        final int m = heights[0].length;
        final boolean[][] seen = new boolean[n][m];
        pq.offer(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int x = curr[1];
            final int y = curr[2];
            if (x == n - 1 && y == m - 1) {
                return curr[0];
            }
            if (seen[x][y]) {
                continue;
            }
            seen[x][y] = true;
            for (int[] dir : DIRS) {
                final int nx = x + dir[0];
                final int ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    final int height = Math.max(curr[0], Math.abs(heights[x][y] - heights[nx][ny]));
                    pq.offer(new int[] { height, nx, ny });
                }
            }
        }
        return -1;
    }
}
