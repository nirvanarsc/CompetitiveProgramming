package leetcode.weekly_contests.weekly_0_99.weekly_63;

public class P_749 {

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int containVirus(int[][] grid) {
        int res = 0;
        final int n = grid.length;
        final int m = grid[0].length;
        while (true) {
            boolean[][] visited = new boolean[n][m];
            int x = -1;
            int y = -1;
            int maxP = 0;
            int wall = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        final int[] pAndWall = getPerimeter(grid, i, j, visited, new boolean[n * m]);
                        if (pAndWall[0] > maxP) {
                            maxP = pAndWall[0];
                            wall = pAndWall[1];
                            x = i;
                            y = j;
                        }
                    }
                }
            }
            res += wall;
            if (x == -1 && y == -1) {
                return res;
            }
            floodFill(grid, x, y);
            visited = new boolean[n][m];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        expandVirus(grid, i, j, visited);
                    }
                }
            }
        }
    }

    private static int[] getPerimeter(int[][] grid, int r, int c, boolean[][] visited, boolean[] zeroes) {
        int p = 0, w = 0;
        for (int[] d : DIRS) {
            final int nx = r + d[0];
            final int ny = c + d[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                if (grid[nx][ny] == 0 && !zeroes[nx * grid[0].length + ny]) {
                    zeroes[nx * grid[0].length + ny] = true;
                    p++;
                }
                if (grid[nx][ny] == 0) {
                    w++;
                }
                if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    final int[] perimeter = getPerimeter(grid, nx, ny, visited, zeroes);
                    p += perimeter[0];
                    w += perimeter[1];
                }
            }
        }
        return new int[] { p, w };
    }

    private static void floodFill(int[][] grid, int r, int c) {
        if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] != 1) {
            return;
        }
        grid[r][c] = -1;
        for (int[] d : DIRS) {
            floodFill(grid, r + d[0], c + d[1]);
        }
    }

    private static void expandVirus(int[][] grid, int r, int c, boolean[][] visited) {
        for (int[] d : DIRS) {
            final int nx = r + d[0];
            final int ny = c + d[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                if (grid[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    grid[nx][ny] = 1;
                } else if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    expandVirus(grid, nx, ny, visited);
                }
            }
        }
    }
}
