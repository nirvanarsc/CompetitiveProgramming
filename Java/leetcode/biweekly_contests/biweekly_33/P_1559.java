package leetcode.biweekly_contests.biweekly_33;

public class P_1559 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean containsCycle(char[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, grid, visited, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(int i, int j, char[][] grid, boolean[][] visited, int parX, int parY) {
        final int n = grid.length;
        final int m = grid[0].length;
        visited[i][j] = true;
        final char c = grid[i][j];
        for (int[] dir : DIRS) {
            final int nx = i + dir[0];
            final int ny = j + dir[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == c && !(parX == nx && parY == ny)) {
                if (visited[nx][ny] || dfs(nx, ny, grid, visited, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
