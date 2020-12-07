package leetcode.medium;

public final class P_59 {

    public int[][] generateMatrix(int n) {
        final int[][] res = new int[n][n];
        final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int side = n - 1, i = 0, j = 0, num = 1;
        while (side > 0) {
            for (int[] dir : dirs) {
                for (int k = 0; k < side; k++) {
                    res[i][j] = num++;
                    i += dir[0];
                    j += dir[1];
                }
            }
            i++;
            j++;
            side -= 2;
        }
        if (n % 2 != 0) {
            res[i][j] = num;
        }
        return res;
    }
}
