package leetcode.biweekly_contests.biweekly_0_99.biweekly_62;

public class P_1 {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            //noinspection ZeroLengthArrayAllocation
            return new int[0][0];
        }
        final int[][] res = new int[m][n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[idx++];
            }
        }
        return res;
    }
}
