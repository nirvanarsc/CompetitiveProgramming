package leetcode.weekly_contests.weekly_300_399.weekly_373;

public class P_1 {

    public boolean areSimilar(int[][] mat, int k) {
        final int n = mat.length;
        final int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][(j + 100 * m + (i % 2 == 0 ? -k : k)) % m] != mat[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
