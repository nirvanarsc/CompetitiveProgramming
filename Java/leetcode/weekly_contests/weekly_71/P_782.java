package leetcode.weekly_contests.weekly_71;

public class P_782 {

    public int movesToChessboard(int[][] board) {
        final int n = board.length;
        int rowSum = 0;
        int colSum = 0;
        int rowSwap = 0;
        int colSwap = 0;
        for (int[] row : board) {
            for (int j = 0; j < n; j++) {
                if ((board[0][0] ^ row[0] ^ board[0][j] ^ row[j]) == 1) {
                    return -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            rowSum += board[0][i];
            colSum += board[i][0];
            if (board[i][0] == i % 2) {
                rowSwap++;
            }
            if (board[0][i] == i % 2) {
                colSwap++;
            }
        }
        if (rowSum != n / 2 && rowSum != (n + 1) / 2) {
            return -1;
        }
        if (colSum != n / 2 && colSum != (n + 1) / 2) {
            return -1;
        }
        if (n % 2 == 1) {
            if (colSwap % 2 != 0) {
                colSwap = n - colSwap;
            }
            if (rowSwap % 2 != 0) {
                rowSwap = n - rowSwap;
            }
        } else {
            colSwap = Math.min(n - colSwap, colSwap);
            rowSwap = Math.min(n - rowSwap, rowSwap);
        }
        return (colSwap + rowSwap) / 2;
    }
}
