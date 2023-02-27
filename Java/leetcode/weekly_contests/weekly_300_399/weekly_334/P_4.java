package leetcode.weekly_contests.weekly_300_399.weekly_334;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_4 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = (int) 1e9;
            }
        }
        d[0][0] = 0;
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[] { 0, 0, d[0][0] });
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int u = curr[0];
            final int v = curr[1];
            if (d[u][v] < curr[2]) {
                continue;
            }
            for (int[] dir : DIRS) {
                final int nu = u + dir[0];
                final int nv = v + dir[1];
                if (0 <= nu && nu < n && 0 <= nv && nv < m) {
                    if (grid[nu][nv] > curr[2] + 1) {
                        final int c;
                        if (curr[2] % 2 == 0) {
                            c = grid[nu][nv] + 1 - (grid[nu][nv] % 2);
                        } else {
                            c = grid[nu][nv] + (grid[nu][nv] % 2);
                        }
                        if (c < d[nu][nv]) {
                            d[nu][nv] = c;
                            pq.offer(new int[] { nu, nv, d[nu][nv] });
                        }
                    } else {
                        if (curr[2] + 1 < d[nu][nv]) {
                            d[nu][nv] = curr[2] + 1;
                            pq.offer(new int[] { nu, nv, d[nu][nv] });
                        }
                    }
                }
            }
        }
        return d[n - 1][m - 1];
    }
}
