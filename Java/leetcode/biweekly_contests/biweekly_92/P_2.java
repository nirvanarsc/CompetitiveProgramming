package leetcode.biweekly_contests.biweekly_92;

public class P_2 {

    public int[][] onesMinusZeros(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] res = new int[n][m];
        final int[] or = new int[n];
        final int[] zr = new int[n];
        final int[] oc = new int[m];
        final int[] zc = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    zr[i]++;
                    zc[j]++;
                } else {
                    or[i]++;
                    oc[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = or[i] + oc[j] - zr[i] - zc[j];
            }
        }
        return res;
    }
}
