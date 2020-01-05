package medium;

public class P_695 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        final int n = grid.length;
        final int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, sink(grid, i, j));
                }
            }
        }

        return res;
    }

    private static int sink(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 0;
        int res = 1;
        for (int[] dir : new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }) {
            res += sink(grid, i + dir[0], j + dir[1]);
        }
        return res;
    }

    public int maxAreaOfIsland2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        final int n = grid.length;
        final int m = grid[0].length;
        final boolean[][] visited = new boolean[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    res = Math.max(res, count(grid, visited, i, j));
                }
            }
        }

        return res;
    }

    private static int count(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || visited[i][j] || grid[i][j] != 1) {
            return 0;
        }

        visited[i][j] = true;
        int res = 1;
        for (int[] dir : new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }) {
            res += count(grid, visited, i + dir[0], j + dir[1]);
        }
        return res;
    }
}
