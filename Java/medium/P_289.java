package medium;

public class P_289 {

    private static final int[][] DIRS =
            { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    checkDead(board, i, j);
                } else {
                    checkLiving(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = 0;
                }
                if (board[i][j] == '+') {
                    board[i][j] = 1;
                }
            }
        }
    }

    private static void checkDead(int[][] board, int row, int col) {
        if (countNeighbours(board, row, col) == 3) {
            board[row][col] = '+';
        }
    }

    private static void checkLiving(int[][] board, int row, int col) {
        final int n = countNeighbours(board, row, col);
        if (n == 2 || n == 3) {
            return;
        }
        board[row][col] = '-';
    }

    private static int countNeighbours(int[][] board, int row, int col) {
        int res = 0;
        for (int[] dir : DIRS) {
            res += getNeighbour(board, row + dir[0], col + dir[1]);
        }

        return res;
    }

    private static int getNeighbour(int[][] board, int row, int col) {
        if (row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] == '+') {
            return 0;
        }

        if (board[row][col] == '-') {
            return 1;
        }

        return board[row][col];
    }
}
