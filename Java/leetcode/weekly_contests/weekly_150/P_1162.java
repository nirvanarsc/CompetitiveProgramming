package leetcode.weekly_contests.weekly_150;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1162 {
    private static final int[][] DIRS =
            { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 }, };

    public int maxDistanceBFS(int[][] grid) {
        final Deque<int[]> q = new ArrayDeque<>();
        final boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.offerLast(new int[] { i, j });
                }
            }
        }
        int level = -1;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                final int[] curr = q.removeFirst();
                for (int[] dir : DIRS) {
                    final int newX = curr[0] + dir[0];
                    final int newY = curr[1] + dir[1];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                        && !visited[newX][newY] && grid[newX][newY] == 0) {
                        visited[newX][newY] = true;
                        q.offerLast(new int[] { newX, newY });
                    }
                }
            }
            level++;
        }
        return level <= 0 ? -1 : level;
    }

    public int maxDistance(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 1) {
                    grid[i][j] = 201;
                    if (i > 0) { grid[i][j] = Math.min(grid[i][j], grid[i - 1][j] + 1); }
                    if (j > 0) { grid[i][j] = Math.min(grid[i][j], grid[i][j - 1] + 1); }
                }
            }
        }
        for (int i = n - 1; i > -1; i--) {
            for (int j = m - 1; j > -1; j--) {
                if (grid[i][j] != 1) {
                    if (i < n - 1) { grid[i][j] = Math.min(grid[i][j], grid[i + 1][j] + 1); }
                    if (j < m - 1) { grid[i][j] = Math.min(grid[i][j], grid[i][j + 1] + 1); }
                    res = Math.max(res, grid[i][j]);
                }
            }
        }
        return res == 201 ? -1 : res - 1;
    }
}
