public class AvailableCapturesForRook {

    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'R') {
                    return getCapture(board, i, j);
                }
            }
        }
        return 0;
    }

    int getCapture(char[][] board, int r, int c) {
        int res = 0;
        final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] dir : directions) {
            for (int x = r + dir[0], y = c + dir[1]; x >= 0 && x < board.length && y >= 0 && y < board.length;
                 x += dir[0], y += dir[1]) {
                if (board[x][y] == 'p') { res++; }
                if (board[x][y] != '.') { break; }
            }
        }
        return res;
    }
}
