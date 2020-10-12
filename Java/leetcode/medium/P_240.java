package leetcode.medium;

public class P_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        return helper(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    public static boolean helper(int[][] matrix, int t, int rL, int rH, int cL, int cH) {
        if (rL > rH || cL > cH) {
            return false;
        }

        final int rM = rL + rH >>> 1;
        final int cM = cL + cH >>> 1;
        if (matrix[rM][cM] == t) {
            return true;
        } else if (matrix[rM][cM] > t) {
            return helper(matrix, t, rL, rH, cL, cM - 1) || helper(matrix, t, rL, rM - 1, cM, cH);
        } else {
            return helper(matrix, t, rL, rH, cM + 1, cH) || helper(matrix, t, rM + 1, rH, cL, cM);
        }
    }
}
