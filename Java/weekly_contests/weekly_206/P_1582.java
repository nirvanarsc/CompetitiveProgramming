package weekly_contests.weekly_206;

public class P_1582 {

    public int numSpecial(int[][] mat) {
        final int n = mat.length;
        final int m = mat[0].length;
        int res = 0;
        final int[] rows = new int[n];
        final int[] cols = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rows[i] += mat[i][j];
                cols[j] += mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
