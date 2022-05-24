package leetcode.weekly_contests.weekly_100_199.weekly_167;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_1293 {

    private static final int[][] DIRS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int shortestPath(int[][] grid, int k) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][][] dp = new int[n][m][k + 1];
        for (int[][] r1 : dp) {
            for (int[] r2 : r1) {
                Arrays.fill(r2, (int) 1e9);
            }
        }
        dp[0][0][k] = 0;
        final Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { 0, 0, k });
        while (!dq.isEmpty()) {
            final int[] curr = dq.removeFirst();
            final int x = curr[0];
            final int y = curr[1];
            final int skip = curr[2];
            for (int[] dir : DIRS) {
                final int nx = x + dir[0];
                final int ny = y + dir[1];
                int nextSkip = skip;
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (grid[nx][ny] == 1) {
                        nextSkip--;
                    }
                    if (nextSkip >= 0 && dp[nx][ny][nextSkip] > dp[x][y][skip] + 1) {
                        dp[nx][ny][nextSkip] = dp[x][y][skip] + 1;
                        dq.offerLast(new int[] { nx, ny, nextSkip });
                    }
                }
            }
        }
        int res = (int) 1e9;
        for (int i = 0; i <= k; i++) {
            res = Math.min(res, dp[n - 1][m - 1][i]);
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
