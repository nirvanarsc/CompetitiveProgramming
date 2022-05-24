package leetcode.weekly_contests.weekly_100_199.weekly_124;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_994 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int orangesRotting(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] d = new int[n][m];
        final Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = (int) 1e9;
                if (grid[i][j] == 2) {
                    dq.offerLast(new int[] { i, j });
                }
            }
        }
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int[] curr = dq.removeFirst();
                final int u = curr[0];
                final int v = curr[1];
                if (d[u][v] < level || grid[u][v] == 0) {
                    continue;
                }
                d[u][v] = level;
                for (int[] dir : DIRS) {
                    final int nx = u + dir[0];
                    final int ny = v + dir[1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        dq.offerLast(new int[] { nx, ny });
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, d[i][j]);
                }
            }
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
