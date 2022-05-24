package leetcode.weekly_contests.weekly_200_299.weekly_244;

import java.util.Arrays;

public class P_1 {

    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (eq(mat, target)) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }

    private static boolean eq(int[][] l, int[][] r) {
        final int n = l.length;
        for (int i = 0; i < n; i++) {
            if (!Arrays.equals(l[i], r[i])) {
                return false;
            }
        }
        return true;
    }

    public void rotate(int[][] matrix) {
        final int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            for (int i = layer; i < (n - 1 - layer); i++) {
                final int topL = matrix[layer][i];
                final int topR = matrix[i][n - 1 - layer];
                final int botR = matrix[n - 1 - layer][n - 1 - i];
                final int botL = matrix[n - 1 - i][layer];
                matrix[layer][i] = botL;
                matrix[i][n - 1 - layer] = topL;
                matrix[n - 1 - layer][n - 1 - i] = topR;
                matrix[n - 1 - i][layer] = botR;
            }
        }
    }
}
