package medium;

public class P_200 {

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        final int n = grid.length;
        final int m = grid[0].length;
        int res = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1') {
                    res++;
                    fillLand(row, col, grid);
                }
            }
        }
        return res;
    }

    private static void fillLand(int row, int col, char[][] grid) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '*';
        for (int[] dir : new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }) {
            fillLand(row + dir[0], col + dir[1], grid);
        }
    }
}
