package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class P_505 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int shortestDistanceDijkstra(int[][] maze, int[] start, int[] destination) {
        final int n = maze.length;
        final int m = maze[0].length;
        final boolean[][] visited = new boolean[n][m];
        final PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        q.offer(new int[] { start[0], start[1], 0 });
        while (!q.isEmpty()) {
            final int[] curr = q.remove();
            final int x = curr[0];
            final int y = curr[1];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            if (destination[0] == x && destination[1] == y) {
                return curr[2];
            }
            for (int[] dir : DIRS) {
                int nx = x;
                int ny = y;
                int dist = 0;
                while (nx + dir[0] >= 0 && nx + dir[0] < n && ny + dir[1] >= 0 && ny + dir[1] < m
                       && maze[nx + dir[0]][ny + dir[1]] == 0) {
                    nx += dir[0];
                    ny += dir[1];
                    dist++;
                }
                q.offer(new int[] { nx, ny, curr[2] + dist });
            }
        }
        return -1;
    }

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        final int n = maze.length;
        final int m = maze[0].length;
        final int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[start[0]][start[1]] = 0;
        final Deque<int[]> q = new ArrayDeque<>(Collections.singleton(new int[] { start[0], start[1], 0 }));
        while (!q.isEmpty()) {
            final int[] curr = q.remove();
            final int x = curr[0];
            final int y = curr[1];
            for (int[] dir : DIRS) {
                int nx = x;
                int ny = y;
                int dist = 0;
                while (nx + dir[0] >= 0 && nx + dir[0] < n && ny + dir[1] >= 0 && ny + dir[1] < m
                       && maze[nx + dir[0]][ny + dir[1]] == 0) {
                    nx += dir[0];
                    ny += dir[1];
                    dist++;
                }
                if (dp[x][y] + dist < dp[nx][ny]) {
                    dp[nx][ny] = dp[x][y] + dist;
                    q.offer(new int[] { nx, ny, curr[2] + dist });
                }
            }
        }
        return dp[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : dp[dest[0]][dest[1]];
    }
}
