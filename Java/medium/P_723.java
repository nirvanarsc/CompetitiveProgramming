package medium;

public class P_723 {

    public int[][] candyCrush(int[][] board) {
        final int n = board.length;
        final int m = board[0].length;
        boolean crush = true;
        while (crush) {
            crush = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    final int val = Math.abs(board[i][j]);
                    if (val != 0) {
                        if (j < m - 2 && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
                            crush = true;
                            int ind = j;
                            while (ind < m && Math.abs(board[i][ind]) == val) {
                                board[i][ind++] = -val;
                            }
                        }
                        if (i < n - 2 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
                            crush = true;
                            int ind = i;
                            while (ind < n && Math.abs(board[ind][j]) == val) {
                                board[ind++][j] = -val;
                            }
                        }
                    }
                }
            }
            if (crush) {
                for (int j = 0; j < m; j++) {
                    int storeInd = n - 1;
                    for (int i = n - 1; i >= 0; i--) {
                        if (board[i][j] > 0) {
                            board[storeInd--][j] = board[i][j];
                        }
                    }
                    for (int k = storeInd; k >= 0; k--) {
                        board[k][j] = 0;
                    }
                }
            }
        }
        return board;
    }
}
