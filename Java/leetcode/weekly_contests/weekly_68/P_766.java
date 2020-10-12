package leetcode.weekly_contests.weekly_68;

public class P_766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length - 1; r++) {
            if (!checkRows(matrix[r], matrix[r + 1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRows(int[] up, int[] down) {
        for (int i = 0; i < up.length - 1; i++) {
            if (up[i] != down[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
