package medium;

public class P_361 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int maxKilledEnemiesBF(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    int curr = 0;
                    for (int[] dir : DIRS) {
                        int nx = i;
                        int ny = j;
                        while (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[i].length
                               && grid[nx][ny] != 'W') {
                            if (grid[nx][ny] == 'E') {
                                curr++;
                            }
                            nx += dir[0];
                            ny += dir[1];
                        }
                    }
                    res = Math.max(res, curr);
                }
            }
        }
        return res;
    }

    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        final int n = grid.length;
        final int m = grid[0].length;
        int result = 0;
        int rowhits = 0;
        final int[] colhits = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowhits = 0;
                    for (int k = j; k < m && grid[i][k] != 'W'; k++) {
                        rowhits += grid[i][k] == 'E' ? 1 : 0;
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colhits[j] = 0;
                    for (int k = i; k < n && grid[k][j] != 'W'; k++) {
                        colhits[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }
                if (grid[i][j] == '0') {
                    result = Math.max(result, rowhits + colhits[j]);
                }
            }
        }
        return result;
    }
}
