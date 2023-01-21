package leetcode.weekly_contests.weekly_300_399.weekly_328;

public class P_2 {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        final int[][] d = new int[n][n + 1];
        final int[][] res = new int[n][n];
        for (int[] q : queries) {
            for (int i = q[0]; i <= q[2]; i++) {
                d[i][q[1]]++;
                d[i][q[3] + 1]--;
            }
        }
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = 0; j < n; j++) {
                curr += d[i][j];
                res[i][j] = curr;
            }
        }
        return res;
    }
}
