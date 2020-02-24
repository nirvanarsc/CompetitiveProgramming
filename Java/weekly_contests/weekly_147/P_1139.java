package weekly_contests.weekly_147;

public class P_1139 {

    // grid[3][3] = 1 1 1    left[3][3] = 1 2 3    up[3][3] = 1 1 1
    //              1 0 1                 1 0 1               2 0 2
    //              1 1 1                 1 2 3               3 1 3
    public int largest1BorderedSquare(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] left = new int[n][m];
        final int[][] up = new int[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) {
                    left[r][c] = (c > 0) ? left[r][c - 1] + 1 : 1;
                    up[r][c] = (r > 0) ? up[r - 1][c] + 1 : 1;
                }
            }
        }
        for (int side = Math.min(n, m); side > 0; side--) {
            for (int r = 0; r < n - side + 1; r++) {
                for (int c = 0; c < m - side + 1; c++) {
                    if (left[r][c + side - 1] >= side
                        && left[r + side - 1][c + side - 1] >= side
                        && up[r + side - 1][c] >= side
                        && up[r + side - 1][c + side - 1] >= side) {
                        return side * side;
                    }
                }
            }
        }
        return 0;
    }
}
