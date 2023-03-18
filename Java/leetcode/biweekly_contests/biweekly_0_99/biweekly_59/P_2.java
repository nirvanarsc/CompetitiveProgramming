package leetcode.biweekly_contests.biweekly_0_99.biweekly_59;

public class P_2 {

    public long maxMatrixSum(int[][] matrix) {
        int neg = 0;
        long sum = 0;
        int min = (int) 1e9;
        final int m = matrix[0].length;
        for (int[] row : matrix) {
            for (int j = 0; j < m; j++) {
                if (row[j] < 0) {
                    neg++;
                }
                sum += Math.abs(row[j]);
                min = Math.min(min, Math.abs(row[j]));
            }
        }
        if (neg % 2 != 0) {
            return sum - 2 * min;
        }
        return sum;
    }
}
