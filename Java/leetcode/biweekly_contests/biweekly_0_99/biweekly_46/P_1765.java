package leetcode.biweekly_contests.biweekly_0_99.biweekly_46;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_1765 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] highestPeak(int[][] isWater) {
        final int n = isWater.length;
        final int m = isWater[0].length;
        final int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, (int) 5e5);
        }
        final Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    q.offerLast(new int[] { i, j });
                }
            }
        }
        bfs(isWater, dist, q);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == (int) 5e5) {
                    dist[i][j] = 0;
                }
            }
        }
        return dist;
    }

    private static void bfs(int[][] grid, int[][] dist, Deque<int[]> q) {
        for (int level = 0; !q.isEmpty(); level++) {
            for (int size = q.size(); size > 0; size--) {
                final int[] ints = q.removeFirst();
                final int x = ints[0];
                final int y = ints[1];
                if (level > dist[x][y]) {
                    continue;
                }
                for (int[] dir : DIRS) {
                    final int nx = x + dir[0];
                    final int ny = y + dir[1];
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 0) {
                        if (dist[nx][ny] > level + 1) {
                            dist[nx][ny] = level + 1;
                            q.offerLast(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
    }
}
