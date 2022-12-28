package leetcode.weekly_contests.weekly_300_399.weekly_323;

import java.util.Arrays;

public class P_1 {

    public int deleteGreatestValue(int[][] grid) {
        final int m = grid[0].length;
        for (int[] row : grid) {
            Arrays.sort(row);
        }
        int res = 0;
        for (int j = 0; j < m; j++) {
            int curr = 0;
            for (int[] rows : grid) {
                curr = Math.max(curr, rows[j]);
            }
            res += curr;
        }
        return res;
    }
}
