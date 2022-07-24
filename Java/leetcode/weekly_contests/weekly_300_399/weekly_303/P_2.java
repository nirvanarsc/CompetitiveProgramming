package leetcode.weekly_contests.weekly_300_399.weekly_303;

public class P_2 {

    public int equalPairs(int[][] grid) {
        final int n = grid.length;
        int res = 0;
        for (int[] row : grid) {
            for (int j = 0; j < n; j++) {
                boolean ok = true;
                for (int k = 0; k < n; k++) {
                    ok &= grid[k][j] == row[k];
                }
                res += ok ? 1 : 0;
            }
        }
        return res;
    }
}
