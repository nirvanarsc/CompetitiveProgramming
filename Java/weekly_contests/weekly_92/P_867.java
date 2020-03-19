package weekly_contests.weekly_92;

public class P_867 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[][] transpose(int[][] A) {
        final int n = A.length;
        final int m = A[0].length;
        final int[][] B = new int[m][n];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}
