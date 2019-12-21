package medium;

public final class P_130 {

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        final int n = board.length;
        final int m = board[0].length;

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                fill(board, i, 0, n, m);
            }
            if (board[i][m - 1] == 'O') {
                fill(board, i, m - 1, n, m);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                fill(board, 0, i, n, m);
            }
            if (board[n - 1][i] == 'O') {
                fill(board, n - 1, i, n, m);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void fill(char[][] board, int startR, int startC, int n, int m) {
        if (startR < 0 || startR == n || startC < 0 || startC == m || board[startR][startC] != 'O') {
            return;
        }

        board[startR][startC] = '*';
        for (int[] dir : new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }) {
            fill(board, startR + dir[0], startC + dir[1], n, m);
        }
    }
}
