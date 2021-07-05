package leetcode.weekly_contests.weekly_30;

public class P_566 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        final int n = mat.length;
        final int m = mat[0].length;
        if (n * m != r * c) {
            return mat;
        }
        final int[][] res = new int[r][c];
        for (int i = 0; i < n * m; i++) {
            res[i / c][i % c] = mat[i / m][i % m];
        }
        return res;
    }
}
