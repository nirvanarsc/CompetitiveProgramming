package biweekly_contests.biweekly_34;

public class P_1572 {

    public int diagonalSum(int[][] mat) {
        final int n = mat.length;
        int sum = 0;
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            sum += mat[i][i];
            sum += mat[i][j];
        }
        return sum;
    }
}
