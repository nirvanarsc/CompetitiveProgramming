package leetcode.biweekly_contests.biweekly_0_99.biweekly_56;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_2 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int nearestExit(char[][] maze, int[] entrance) {
        final int n = maze.length;
        final int m = maze[0].length;
        final int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, (int) 1e9);
        }
        dp[entrance[0]][entrance[1]] = 0;
        final Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(entrance);
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final int[] curr = dq.removeFirst();
                final int x = curr[0];
                final int y = curr[1];
                if (dp[x][y] < level) {
                    continue;
                }
                for (int[] dir : DIRS) {
                    final int nx = x + dir[0];
                    final int ny = y + dir[1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m && maze[nx][ny] == '.') {
                        if (dp[nx][ny] > dp[x][y] + 1) {
                            dp[nx][ny] = dp[x][y] + 1;
                            dq.offerLast(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
        int res = (int) 1e9;
        dp[entrance[0]][entrance[1]] = res;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    res = Math.min(res, dp[i][j]);
                }
            }
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
