package leetcode.weekly_contests.weekly_300_399.weekly_343;

public class P_2 {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        final int n = mat.length;
        final int m = mat[0].length;
        final int[] col = new int[n];
        final int[] row = new int[m];
        final int[] idx = new int[n * m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                idx[mat[i][j]] = i * m + j;
            }
        }
        for (int i = 0; i < n * m; i++) {
            final int r = idx[arr[i]] / m;
            final int c = idx[arr[i]] % m;
            if (++col[r] == m) {
                return i;
            }
            if (++row[c] == n) {
                return i;
            }
        }
        return -1;
    }
}
