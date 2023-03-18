package leetcode.biweekly_contests.biweekly_0_99.biweekly_77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class P_4 {

    private static final int[][] DIRS = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

    static List<int[]> path;
    static int n;
    static int m;

    public int maximumMinutes(int[][] grid) {
        final Deque<int[]> fire = new ArrayDeque<>();
        n = grid.length;
        m = grid[0].length;
        path = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fire.offerLast(new int[] { i, j });
                }
            }
        }
        final int[][] d1 = bfs1(grid, fire);
        final int[][] d2 = bfs2(grid, d1);
        if (d2[n - 1][m - 1] == (int) 1e9) {
            return -1;
        }
        if (d1[n - 1][m - 1] == (int) 1e9) {
            return (int) 1e9;
        }
        final int t = d1[n - 1][m - 1] - d2[n - 1][m - 1];
        if (t < 0) {
            return -1;
        }
        int res = t;
        for (int[] s : path) {
            final int i = s[0];
            final int j = s[1];
            final int v = (i == n - 1 && j == m - 1) ? 0 : 1;
            res = Math.min(res, d1[i][j] - d2[i][j] - v);
        }
        return res;
    }

    private static int[][] bfs1(int[][] g, Deque<int[]> dq) {
        final int[][] d = new int[n][m];
        for (int[] row : d) {
            Arrays.fill(row, (int) 1e9);
        }
        for (int[] c : dq) {
            d[c[0]][c[1]] = 0;
        }
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int[] pop = dq.removeFirst();
                final int x = pop[0];
                final int y = pop[1];
                if (d[x][y] < level) {
                    continue;
                }
                for (int[] dir : DIRS) {
                    final int nx = x + dir[0];
                    final int ny = y + dir[1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m && g[nx][ny] == 0) {
                        if (d[x][y] + 1 < d[nx][ny]) {
                            d[nx][ny] = d[x][y] + 1;
                            dq.offerLast(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
        return d;
    }

    private static int[][] bfs2(int[][] g, int[][] monsters) {
        final int[][] d = new int[n][m];
        final int[][][] prev = new int[n][m][2];
        for (int[] row : d) {
            Arrays.fill(row, (int) 1e9);
        }
        d[0][0] = 0;
        final PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[2] == b[2] ? Integer.compare(monsters[b[0]][b[1]], monsters[a[0]][a[1]])
                                       : Integer.compare(a[2], b[2]));
        pq.offer(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            final int[] pop = pq.remove();
            final int x = pop[0];
            final int y = pop[1];
            final int dd = pop[2];
            if (x == n - 1 && y == m - 1) {
                path.add(new int[] { n - 1, m - 1 });
                int u = n - 1;
                int v = m - 1;
                while (u != 0) {
                    final int[] pp = prev[u][v];
                    path.add(new int[] { pp[0], pp[1] });
                    u = pp[0];
                    v = pp[1];
                }
                path.add(new int[] { 0, 0 });
                break;
            }
            if (d[x][y] < dd || d[x][y] >= monsters[x][y]) {
                continue;
            }
            for (int[] dir : DIRS) {
                final int nx = x + dir[0];
                final int ny = y + dir[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && g[nx][ny] == 0) {
                    if (d[x][y] + 1 < d[nx][ny]) {
                        if (d[x][y] + 1 <= monsters[nx][ny]) {
                            d[nx][ny] = d[x][y] + 1;
                            pq.offer(new int[] { nx, ny, d[nx][ny] });
                            prev[nx][ny] = new int[] { x, y };
                        }
                    }
                }
            }
        }
        return d;
    }
}
