package leetcode.weekly_contests.weekly_224;

import java.util.Arrays;

public class P_1728 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        final int n = grid.length;
        final int m = grid[0].length();
        final char[][] g = new char[n][m];
        for (int i = 0; i < n; i++) {
            g[i] = grid[i].toCharArray();
        }
        final int[] cc = { -1, -1 };
        final int[] mm = { -1, -1 };
        final int[] cake = { -1, -1 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'C') {
                    cc[0] = i;
                    cc[1] = j;
                } else if (g[i][j] == 'M') {
                    mm[0] = i;
                    mm[1] = j;
                } else if (g[i][j] == 'F') {
                    cake[0] = i;
                    cake[1] = j;
                }
            }
        }
        final int[][][][][] dp = new int[8][8][8][8][70];
        for (int[][][][] r1 : dp) {
            for (int[][][] r2 : r1) {
                for (int[][] r3 : r2) {
                    for (int[] r4 : r3) {
                        Arrays.fill(r4, -1);
                    }
                }
            }
        }
        return dfs(g, mm[0], mm[1], cc[0], cc[1], cake[0], cake[1], 0, mouseJump, catJump, dp) == 1;
    }

    private static int dfs(char[][] g, int mx, int my, int cx, int cy, int fx, int fy,
                           int turn, int mj, int cj, int[][][][][] dp) {
        if (mx == fx && my == fy) {
            return 1;
        }
        if ((cx == mx && cy == my) || (cx == fx && cy == fy) || turn == 70) {
            return 0;
        }
        if (dp[mx][my][cx][cy][turn] != -1) {
            return dp[mx][my][cx][cy][turn];
        }
        int res;
        final boolean[] banned = new boolean[4];
        if (turn % 2 == 0) {
            res = dfs(g, mx, my, cx, cy, fx, fy, turn + 1, mj, cj, dp);
            for (int k = 1; k <= mj; k++) {
                for (int j = 0; j < DIRS.length; j++) {
                    final int[] dir = DIRS[j];
                    final int nx = mx + k * dir[0];
                    final int ny = my + k * dir[1];
                    if (nx >= 0 && nx < g.length && ny >= 0 && ny < g[0].length) {
                        if (g[nx][ny] == '#') {
                            banned[j] = true;
                        }
                        if (g[nx][ny] != '#' && !banned[j]) {
                            res = Math.max(res, dfs(g, nx, ny, cx, cy, fx, fy, turn + 1, mj, cj, dp));
                        }
                    }
                }
            }
        } else {
            res = dfs(g, mx, my, cx, cy, fx, fy, turn + 1, mj, cj, dp);
            for (int k = 1; k <= cj; k++) {
                for (int j = 0; j < DIRS.length; j++) {
                    final int[] dir = DIRS[j];
                    final int nx = cx + k * dir[0];
                    final int ny = cy + k * dir[1];
                    if (nx >= 0 && nx < g.length && ny >= 0 && ny < g[0].length) {
                        if (g[nx][ny] == '#') {
                            banned[j] = true;
                        }
                        if (g[nx][ny] != '#' && !banned[j]) {
                            res = Math.min(res, dfs(g, mx, my, nx, ny, fx, fy, turn + 1, mj, cj, dp));
                        }
                    }
                }
            }
        }
        return dp[mx][my][cx][cy][turn] = res;
    }
}
