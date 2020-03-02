package weekly_contests.weekly_125;

public class P_999 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numRookCaptures(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    for (int[] dir : DIRS) {
                        res += searchDir(board, i, j, dir);
                    }
                }
            }
        }
        return res;
    }

    private static int searchDir(char[][] board, int r, int c, int[] dir) {
        while (true) {
            if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 'B') {
                return 0;
            }
            if (board[r][c] == 'p') {
                return 1;
            }
            c += dir[1];
            r += dir[0];
        }
    }
}
