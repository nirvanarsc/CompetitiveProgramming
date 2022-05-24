package leetcode.weekly_contests.weekly_0_99.weekly_84;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_832 {

    public int[][] flipAndInvertImage(int[][] A) {
        final int m = A[0].length;
        for (int[] row : A) {
            for (int i = 0, j = m - 1; i < m / 2; i++, j--) {
                if (row[i] == row[j]) {
                    row[i] ^= 1;
                    row[j] ^= 1;
                }
            }
            if (m % 2 != 0) {
                row[m / 2] ^= 1;
            }
        }
        return A;
    }
}
