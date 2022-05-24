package leetcode.weekly_contests.weekly_100_199.weekly_130;

public class P_1020 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numEnclaves(int[][] A) {
        final int n = A.length;
        final int m = A[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (A[i][0] == 1) { fill(A, i, 0); }
            if (A[i][m - 1] == 1) { fill(A, i, m - 1); }
        }
        for (int i = 0; i < m; i++) {
            if (A[0][i] == 1) { fill(A, 0, i); }
            if (A[n - 1][i] == 1) { fill(A, m - 1, i); }
        }
        for (int[] ints : A) {
            for (int i = 0; i < m; i++) { res += ints[i]; }
        }
        return res;
    }

    private static void fill(int[][] A, int r, int c) {
        if (r < 0 || r >= A.length || c < 0 || c >= A[0].length || A[r][c] == 0) {
            return;
        }
        A[r][c] = 0;
        for (int[] dir : DIRS) {
            fill(A, r + dir[0], c + dir[1]);
        }
    }
}
