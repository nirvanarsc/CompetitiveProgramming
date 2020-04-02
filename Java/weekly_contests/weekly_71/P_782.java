package weekly_contests.weekly_71;

public class P_782 {

    public int movesToChessboard(int[][] b) {
        final int N = b.length;
        int rowSum = 0, colSum = 0, rowSwap = 0, colSwap = 0;
        for (int[] row : b) {
            for (int j = 0; j < N; ++j) {
                if ((b[0][0] ^ row[0] ^ b[0][j] ^ row[j]) == 1) {
                    return -1;
                }
            }
        }
        for (int i = 0; i < N; ++i) {
            rowSum += b[0][i];
            colSum += b[i][0];
            if (b[i][0] == i % 2) {
                rowSwap++;
            }
            if (b[0][i] == i % 2) {
                colSwap++;
            }
        }
        if (rowSum != N / 2 && rowSum != (N + 1) / 2) {
            return -1;
        }
        if (colSum != N / 2 && colSum != (N + 1) / 2) {
            return -1;
        }
        if (N % 2 == 1) {
            if (colSwap % 2 != 0) {
                colSwap = N - colSwap;
            }
            if (rowSwap % 2 != 0) {
                rowSwap = N - rowSwap;
            }
        } else {
            colSwap = Math.min(N - colSwap, colSwap);
            rowSwap = Math.min(N - rowSwap, rowSwap);
        }
        return (colSwap + rowSwap) / 2;
    }
}
