package leetcode.weekly_contests.weekly_141;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class P_1091 {
    private static final int[][] DIRS =
            { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }
        final boolean[][] visited = new boolean[n][m];
        final int[] target = { n - 1, m - 1 };
        visited[0][0] = true;
        final Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] { 0, 0 });
        int ans = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                final int[] curr = queue.removeFirst();
                if (Arrays.equals(curr, target)) {
                    return ans + 1;
                }
                for (int[] dir : DIRS) {
                    final int nextX = curr[0] + dir[0];
                    final int nextY = curr[1] + dir[1];
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY]
                        && grid[nextX][nextY] == 0) {
                        queue.offerLast(new int[] { nextX, nextY });
                        visited[nextX][nextY] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
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
