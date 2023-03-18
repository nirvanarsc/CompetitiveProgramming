package leetcode.biweekly_contests.biweekly_0_99.biweekly_77;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_4_BS {

    private static final int[][] DIRS = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

    static int n;
    static int m;

    public int maximumMinutes(int[][] grid) {
        final Deque<int[]> fire = new ArrayDeque<>();
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fire.offerLast(new int[] { i, j });
                }
            }
        }
        final int[][] d = bfs(grid, fire);
        if (!ok(grid, d, 0)) {
            return -1;
        }
        int lo = 0;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (ok(grid, d, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo == (int) 1e9 ? (int) 1e9 : lo;
    }

    private static boolean ok(int[][] g, int[][] d, int mid) {
        final Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[] { 0, 0 });
        final int[][] dd = new int[n][m];
        for (int[] row : dd) {
            Arrays.fill(row, (int) 2e9);
        }
        dd[0][0] = mid;
        for (int level = mid; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int[] pop = dq.removeFirst();
                final int x = pop[0];
                final int y = pop[1];
                if (x == n - 1 && y == m - 1) {
                    return d[x][y] >= dd[x][y];
                }
                if (dd[x][y] < level || d[x][y] <= dd[x][y]) {
                    continue;
                }
                for (int[] dir : DIRS) {
                    final int nx = x + dir[0];
                    final int ny = y + dir[1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m && g[nx][ny] == 0) {
                        if (dd[x][y] + 1 < dd[nx][ny]) {
                            dd[nx][ny] = dd[x][y] + 1;
                            dq.offerLast(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
        return false;
    }

    private static int[][] bfs(int[][] g, Deque<int[]> dq) {
        final int[][] d = new int[n][m];
        for (int[] row : d) {
            Arrays.fill(row, (int) 2e9);
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
}
