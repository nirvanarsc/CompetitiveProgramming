package hard;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_317 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int shortestDistance(int[][] grid) {
        final int[][] dist = new int[grid.length][grid[0].length];
        final int[][] reach = new int[grid.length][grid[0].length];
        int total = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    total++;
                    bfs(grid, dist, reach, i, j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (reach[i][j] == total) {
                    res = Math.min(res, dist[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static void bfs(int[][] grid, int[][] dist, int[][] reach, int i, int j) {
        final Deque<int[]> q = new ArrayDeque<>(Collections.singleton(new int[] { i, j }));
        final boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int level = 0; !q.isEmpty(); level++) {
            for (int k = q.size(); k > 0; k--) {
                final int[] ints = q.removeFirst();
                final int x = ints[0];
                final int y = ints[1];
                if (!visited[x][y]) {
                    if (grid[x][y] != 1) {
                        reach[x][y]++;
                    }
                    visited[x][y] = true;
                    dist[x][y] += level;
                    for (int[] dir : DIRS) {
                        final int nx = x + dir[0];
                        final int ny = y + dir[1];
                        if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length
                            && !visited[nx][ny] && grid[nx][ny] == 0) {
                            q.offerLast(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
    }
}
