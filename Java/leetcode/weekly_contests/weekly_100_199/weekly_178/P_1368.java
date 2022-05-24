package leetcode.weekly_contests.weekly_100_199.weekly_178;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_1368 {

    private static final int[][] DIRS = { { 0, 1, 1 }, { 0, -1, 2 }, { 1, 0, 3 }, { -1, 0, 4 }, };

    public int minCost(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[] dp = new int[n * m];
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;
        final Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[] { 0, 0 });
        while (!dq.isEmpty()) {
            final int[] curr = dq.removeFirst();
            final int x = curr[0];
            final int y = curr[1];
            for (int[] dir : DIRS) {
                final int nx = x + dir[0];
                final int ny = y + dir[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    final int nw = grid[x][y] == dir[2] ? 0 : 1;
                    final int u = getIdx(m, nx, ny);
                    final int v = getIdx(m, x, y);
                    // 0-1 BFS
                    // https://cp-algorithms.com/graph/01_bfs.html
                    if (dp[u] > dp[v] + nw) {
                        dp[u] = dp[v] + nw;
                        if (grid[x][y] == dir[2]) {
                            dq.offerFirst(new int[] { nx, ny, nw });
                        } else {
                            dq.offerLast(new int[] { nx, ny, nw });
                        }
                    }
                }
            }
        }
        return dp[getIdx(m, n - 1, m - 1)] == (int) 1e9 ? -1 : dp[(n * m) - 1];
    }

    private static int getIdx(int m, int x, int y) {
        return (x * m) + y;
    }
}
