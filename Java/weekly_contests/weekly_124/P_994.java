package weekly_contests.weekly_124;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_994 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int orangesRotting(int[][] grid) {
        final Deque<int[]> q = new ArrayDeque<>();
        final int n = grid.length;
        final int m = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) { fresh++; }
                if (grid[i][j] == 2) { q.offerLast(new int[] { i, j }); }
            }
        }
        if (fresh == 0) { return 0; }
        final boolean[][] visited = new boolean[n][m];
        int level = -1;
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; k--) {
                final int[] ints = q.removeFirst();
                visited[ints[0]][ints[1]] = true;
                for (int[] dir : DIRS) {
                    final int newX = ints[0] + dir[0];
                    final int newY = ints[1] + dir[1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m
                        && !visited[newX][newY] && grid[newX][newY] == 1) {
                        visited[newX][newY] = true;
                        q.offerLast(new int[] { newX, newY });
                        fresh--;
                    }
                }
            }
            level++;
        }
        return fresh == 0 ? level : -1;
    }
}
