package leetcode.weekly_contests.weekly_141;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class P_1091 {
    private static final int[][] DIRS =
            { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        final Deque<int[]> q = new ArrayDeque<>();
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] d = new int[n][m];
        for (int[] row : d) {
            Arrays.fill(row, (int) 1e9);
        }
        if (grid[0][0] == 0) {
            d[0][0] = 1;
            q.offerLast(new int[] { 0, 0 });
        }
        for (int level = 1; !q.isEmpty(); level++) {
            for (int size = q.size(); size > 0; size--) {
                final int[] curr = q.removeFirst();
                final int x = curr[0];
                final int y = curr[1];
                if (d[x][y] < level) {
                    continue;
                }
                for (int[] dir : DIRS) {
                    final int nx = x + dir[0];
                    final int ny = y + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 0) {
                        if (d[nx][ny] > d[x][y] + 1) {
                            d[nx][ny] = d[x][y] + 1;
                            q.offerLast(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
        return d[n - 1][m - 1] == (int) 1e9 ? -1 : d[n - 1][m - 1];
    }

    public int shortestPathBinaryMatrixPQ(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }
        final boolean[][] added = new boolean[n][m];
        final int[][] sPaths = new int[n][m];
        for (int[] row : sPaths) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        sPaths[0][0] = 1;
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> sPaths[a[0]][a[1]]));
        pq.offer(new int[] { 0, 0 });
        while (!pq.isEmpty()) {
            final int[] poll = pq.poll();
            if (Arrays.equals(poll, new int[] { n - 1, m - 1 })) { return sPaths[poll[0]][poll[1]]; }
            for (int[] dir : DIRS) {
                final int newX = poll[0] + dir[0];
                final int newY = poll[1] + dir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 0
                    && !added[newX][newY]) {
                    added[newX][newY] = true;
                    pq.offer(new int[] { newX, newY });
                    sPaths[newX][newY] = Math.min(sPaths[newX][newY], sPaths[poll[0]][poll[1]] + 1);
                }
            }
        }
        return -1;
    }
}
