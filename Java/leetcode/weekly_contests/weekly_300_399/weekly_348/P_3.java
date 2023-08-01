package leetcode.weekly_contests.weekly_300_399.weekly_348;

public class P_3 {

    public long matrixSumQueries(int n, int[][] queries) {
        final boolean[] seenRow = new boolean[n];
        final boolean[] seenCol = new boolean[n];
        final int q = queries.length;
        long sum = 0;
        int row = n;
        int col = n;
        for (int i = q - 1; i >= 0; i--) {
            if (queries[i][0] == 0) {
                final int r = queries[i][1];
                final int v = queries[i][2];
                if (!seenRow[r]) {
                    seenRow[r] = true;
                    sum += (long) v * col;
                    row--;
                }
            } else {
                final int c = queries[i][1];
                final int v = queries[i][2];
                if (!seenCol[c]) {
                    seenCol[c] = true;
                    sum += (long) v * row;
                    col--;
                }
            }
        }
        return sum;
    }
}
