package binarysearch.weekly_51;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_3 {

    private static final int[][] DIRS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int solve(int[][] matrix) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        final int n = matrix.length;
        final int m = matrix[0].length;
        final boolean[][] seen = new boolean[n][m];
        pq.offer(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int cost = curr[0];
            final int x = curr[1];
            final int y = curr[2];
            if (x == n - 1 && y == m - 1) {
                return cost;
            }
            if (seen[x][y]) {
                continue;
            }
            seen[x][y] = true;
            for (int[] dir : DIRS) {
                final int nx = dir[0] + x;
                final int ny = dir[1] + y;
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    pq.offer(new int[] { cost + Math.abs(matrix[x][y] - matrix[nx][ny]), nx, ny });
                }
            }
        }
        return -1;
    }
}
