package leetcode.weekly_contests.weekly_100_199.weekly_150;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1162 {

    private static final int[][] DIRS = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 }, };

    public int maxDistance(int[][] grid) {
        final Deque<Integer> q = new ArrayDeque<>();
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = (int) 1e9;
                if (grid[i][j] == 1) {
                    d[i][j] = 0;
                    q.offerLast(i * m + j);
                }
            }
        }
        for (int level = 0; !q.isEmpty(); level++) {
            for (int size = q.size(); size > 0; size--) {
                final int curr = q.removeFirst();
                final int r = curr / m;
                final int c = curr % m;
                for (int[] dir : DIRS) {
                    final int nr = r + dir[0];
                    final int nc = c + dir[1];
                    if (0 <= nr && nr < n && 0 <= nc && nc < m && grid[nr][nc] == 0 && d[nr][nc] > level + 1) {
                        d[nr][nc] = level + 1;
                        q.offerLast(nr * m + nc);
                    }
                }
            }
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    res = Math.max(res, d[i][j]);
                }
            }
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
