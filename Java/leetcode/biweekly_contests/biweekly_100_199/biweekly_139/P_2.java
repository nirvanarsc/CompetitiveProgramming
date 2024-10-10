package leetcode.biweekly_contests.biweekly_100_199.biweekly_139;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P_2 {

    private static final int[][] DIRS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        final int n = grid.size();
        final int m = grid.get(0).size();
        final int[][] d = new int[n][m];
        for (int[] row : d) {
            Arrays.fill(row, (int) 1e9);
        }
        d[0][0] = 0;
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[] { 0, 0, d[0][0] });
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int u = curr[0];
            final int v = curr[1];
            final int c = curr[2];
            if (d[u][v] < c) {
                continue;
            }
            for (int[] dir : DIRS) {
                final int nu = dir[0] + u;
                final int nv = dir[1] + v;
                if (0 <= nu && nu < n && 0 <= nv && nv < m && d[nu][nv] > c + grid.get(u).get(v)) {
                    d[nu][nv] = c + grid.get(u).get(v);
                    pq.offer(new int[] { nu, nv, d[nu][nv] });
                }
            }
        }
        return health > d[n - 1][m - 1] + grid.get(n - 1).get(m - 1);
    }
}
