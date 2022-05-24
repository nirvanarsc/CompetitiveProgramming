package leetcode.weekly_contests.weekly_0_99.weekly_61;

public class P_741 {

    public int cherryPickup3d(int[][] grid) {
        final int n = grid.length;
        return Math.max(0, cherryPickup(grid, n, 0, 0, 0, new Integer[n][n][n]));
    }

    private static int cherryPickup(int[][] grid, int n, int r1, int c1, int c2, Integer[][][] dp) {
        final int r2 = r1 + c1 - c2;
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }
        if (r2 == n - 1 && c2 == n - 1) {
            return grid[r2][c2];
        }
        if (dp[r1][c1][c2] != null) {
            return dp[r1][c1][c2];
        }
        final int currStep = r1 == r2 && c1 == c2 ? grid[r1][c1] : grid[r1][c1] + grid[r2][c2];

        final int first = Math.max(cherryPickup(grid, n, r1 + 1, c1, c2, dp),
                                   cherryPickup(grid, n, r1 + 1, c1, c2 + 1, dp));
        final int second = Math.max(cherryPickup(grid, n, r1, c1 + 1, c2, dp),
                                    cherryPickup(grid, n, r1, c1 + 1, c2 + 1, dp));

        return dp[r1][c1][c2] = currStep + Math.max(first, second);
    }

    public int cherryPickup4d(int[][] grid) {
        final int n = grid.length;
        return Math.max(0, cherryPickup(grid, n, 0, 0, 0, 0, new Integer[n][n][n][n]));
    }

    private static int cherryPickup(int[][] grid, int n, int r1, int c1, int r2, int c2, Integer[][][][] dp) {
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }
        if (r2 == n - 1 && c2 == n - 1) {
            return grid[r2][c2];
        }
        if (dp[r1][c1][r2][c2] != null) {
            return dp[r1][c1][r2][c2];
        }
        final int currStep = r1 == r2 && c1 == c2 ? grid[r1][c1] : grid[r1][c1] + grid[r2][c2];

        final int first = Math.max(cherryPickup(grid, n, r1 + 1, c1, r2 + 1, c2, dp),
                                   cherryPickup(grid, n, r1 + 1, c1, r2, c2 + 1, dp));
        final int second = Math.max(cherryPickup(grid, n, r1, c1 + 1, r2 + 1, c2, dp),
                                    cherryPickup(grid, n, r1, c1 + 1, r2, c2 + 1, dp));

        return dp[r1][c1][r2][c2] = currStep + Math.max(first, second);
    }
}
