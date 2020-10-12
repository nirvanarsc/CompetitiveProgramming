package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_490 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        final int n = maze.length;
        final int m = maze[0].length;
        final boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        final Deque<int[]> q = new ArrayDeque<>(Collections.singleton(start));
        while (!q.isEmpty()) {
            final int[] curr = q.removeFirst();
            final int x = curr[0];
            final int y = curr[1];
            if (destination[0] == x && destination[1] == y) {
                return true;
            }
            for (int[] dir : DIRS) {
                int nx = x;
                int ny = y;
                while (nx + dir[0] >= 0 && nx + dir[0] < n && ny + dir[1] >= 0 && ny + dir[1] < m
                       && maze[nx + dir[0]][ny + dir[1]] == 0) {
                    nx += dir[0];
                    ny += dir[1];
                }
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offerLast(new int[] { nx, ny });
                }
            }
        }
        return false;
    }
}
