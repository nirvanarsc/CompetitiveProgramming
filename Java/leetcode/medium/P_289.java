package leetcode.medium;

public class P_289 {

    private static final int[][] DIRS =
            { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    public void gameOfLife(int[][] board) {
        final int n = board.length;
        final int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int c = 0;
                for (int[] dir : DIRS) {
                    final int x = i + dir[0];
                    final int y = j + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < m && Math.abs(board[x][y]) == 1) {
                        c++;
                    }
                }
                if (board[i][j] == 0) {
                    if (c == 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (c != 2 && c != 3) {
                        board[i][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}
