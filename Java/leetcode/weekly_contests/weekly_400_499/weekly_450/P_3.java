package leetcode.weekly_contests.weekly_400_499.weekly_450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P_3 {

    private static final int[][] DIRS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int minMoves(String[] matrix) {
        final List<List<int[]>> g = new ArrayList<>();
        final int n = matrix.length;
        final int m = matrix[0].length();
        for (int i = 0; i < 26; i++) {
            g.add(new ArrayList<>());
        }
        final char[][] grid = new char[n][m];
        final int[][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = matrix[i].toCharArray();
            Arrays.fill(d[i], (int) 1e9);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != '.' && grid[i][j] != '#') {
                    g.get(grid[i][j] - 'A').add(new int[] { i, j });
                }
            }
        }
        d[0][0] = 0;
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { d[0][0], 0, 0 });
        int seen = 0;
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int u = curr[1];
            final int v = curr[2];
            if (d[u][v] < curr[0]) {
                continue;
            }
            for (int[] dir : DIRS) {
                final int nu = dir[0] + u;
                final int nv = dir[1] + v;
                if (0 <= nu && nu < n && 0 <= nv && nv < m && grid[nu][nv] != '#') {
                    if (d[nu][nv] > d[u][v] + 1) {
                        d[nu][nv] = d[u][v] + 1;
                        pq.offer(new int[] { d[nu][nv], nu, nv });
                    }
                }
            }
            if (grid[u][v] != '.' && (seen & (1 << (grid[u][v] - 'A'))) == 0) {
                for (int[] next : g.get(grid[u][v] - 'A')) {
                    final int nu = next[0];
                    final int nv = next[1];
                    if (d[nu][nv] > d[u][v]) {
                        d[nu][nv] = d[u][v];
                        pq.offer(new int[] { d[nu][nv], nu, nv });
                    }
                }
                seen |= 1 << (grid[u][v] - 'A');
            }
        }
        return d[n - 1][m - 1] == (int) 1e9 ? -1 : d[n - 1][m - 1];
    }
}
