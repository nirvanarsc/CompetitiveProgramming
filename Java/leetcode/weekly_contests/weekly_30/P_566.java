package leetcode.weekly_contests.weekly_30;

public class P_566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        final int n = nums.length;
        final int m = nums[0].length;
        if (n * m != r * c) {
            return nums;
        }
        final int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                final int idx = i * c + j;
                res[i][j] = nums[idx / m][idx - (idx / m) * m];
            }
        }
        return res;
    }
}
