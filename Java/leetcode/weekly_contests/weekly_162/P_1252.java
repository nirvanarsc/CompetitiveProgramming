package leetcode.weekly_contests.weekly_162;

public class P_1252 {

    public int oddCells(int n, int m, int[][] indices) {
        final boolean[] oddRows = new boolean[n];
        final boolean[] oddCols = new boolean[m];
        for (int[] idx : indices) {
            oddRows[idx[0]] ^= true;
            oddCols[idx[1]] ^= true;
        }
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                cnt += oddRows[i] ^ oddCols[j] ? 1 : 0;
            }
        }
        return cnt;
    }

    public int oddCellsBruteForce(int n, int m, int[][] indices) {
        final int[][] matrix = new int[n][m];
        for (int[] pair : indices) {
            for (int i = 0; i < m; i++) {
                matrix[pair[0]][i]++;
            }
            for (int i = 0; i < n; i++) {
                matrix[i][pair[1]]++;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % 2 != 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
