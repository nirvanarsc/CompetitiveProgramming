package leetcode.biweekly_contests.biweekly_100_199.biweekly_102;

public class P_1 {

    public int[] findColumnWidth(int[][] grid) {
        final int m = grid[0].length;
        final int[] res = new int[m];
        for (int[] row : grid) {
            for (int j = 0; j < m; j++) {
                res[j] = Math.max(res[j], String.valueOf(row[j]).length());
            }
        }
        return res;
    }
}
