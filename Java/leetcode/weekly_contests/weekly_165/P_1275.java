package leetcode.weekly_contests.weekly_165;

public class P_1275 {

    public String tictactoe(int[][] moves) {
        final int[][] matrix = new int[3][3];
        boolean turn = true;
        for (int[] move : moves) {
            matrix[move[0]][move[1]] = turn ? 1 : -1;
            turn ^= true;
        }
        final String checkRow = checkRowCol(matrix, true);
        if (!checkRow.isEmpty()) {
            return checkRow;
        }
        final String checkCol = checkRowCol(matrix, false);
        if (!checkCol.isEmpty()) {
            return checkCol;
        }
        if (matrix[0][0] + matrix[1][1] + matrix[2][2] == 3
            || matrix[0][2] + matrix[1][1] + matrix[2][0] == 3) {
            return "A";
        }
        if (matrix[0][0] + matrix[1][1] + matrix[2][2] == -3
            || matrix[0][2] + matrix[1][1] + matrix[2][0] == -3) {
            return "B";
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    private static String checkRowCol(int[][] matrix, boolean row) {
        int checkWin = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checkWin += row ? matrix[i][j] : matrix[j][i];
            }
            if (checkWin == 3) {
                return "A";
            }
            if (checkWin == -3) {
                return "B";
            }
            checkWin = 0;
        }
        return "";
    }
}
