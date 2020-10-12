package leetcode.weekly_contests.weekly_84;

public class P_832 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] row : A) {
            for (int i = 0, j = row.length - 1; i <= j; i++, j--) {
                if (row[i] == row[j]) {
                    row[i] = row[j] ^= 1;
                }
            }
        }
        return A;
    }
}
