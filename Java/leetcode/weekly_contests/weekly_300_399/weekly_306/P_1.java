package leetcode.weekly_contests.weekly_300_399.weekly_306;

public class P_1 {

    public int[][] largestLocal(int[][] grid) {
        final int n = grid.length;
        final int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int curr = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        curr = Math.max(curr, grid[k][l]);
                    }
                }
                res[i][j] = curr;
            }
        }
        return res;
    }
}
